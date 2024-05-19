(ns sample.main
  (:require
   [clojure.java.io :as io]
   [clojure.pprint :as pprint]
   [clojure.string :as string]
   [clojure.tools.logging :as log]
   [lambda.util :as util]
   [lambda.uuid :as uuid])
  (:import
   (java.io File)
   (java.io FileInputStream)
   (java.util.zip GZIPInputStream GZIPOutputStream)))

(defn  store-rows
  ^File [cmds]
  (let [file (File/createTempFile "filename" ".json.list")]
    (util/d-time
     (str "Writing commands to local temporary file")
     (with-open [file (io/writer file)]
       (doseq [cmd cmds]
         (.write file
                 (str (util/to-json cmd)
                      "\n"))))
     (System/gc))
    file))



(defn gzip
  [input output & opts]
  (with-open [output (-> output io/output-stream GZIPOutputStream.)]
    (apply io/copy input output opts)))

(defn gzip-commands
  [cmds]
  (let [^File file (store-rows cmds)
        gz-file (File/createTempFile "filename" ".json.list.gz")]

    (util/d-time
     (str "Gziping data")
     (System/gc)
     (util/d-time
      "Gzipping data file"
      (gzip file gz-file))
     (System/gc))
    gz-file))

(defn in-function
  [ro]
  (let [entities
        (util/d-time
         "Loading data"
         (let [tmp (mapv
                    #(select-keys
                      %
                      [:param1
                       :param2])
                    ro)]
           (System/gc)
           (System/gc)
           (System/gc)
           tmp))]
    entities))

(defn stream
  [file]
  (map
   util/to-edn
   (->> (FileInputStream. file)
        io/input-stream
        (new GZIPInputStream)
        io/reader
        line-seq)))

(defn generate
  [& args]
  (util/d-time
   "Prparing"
   (println "Preparing"))
  (let [data-file
        (util/d-time
         "Creating data"
         (let [tmp (.getAbsolutePath
                    (gzip-commands
                     (map (fn [x] {:param1 (uuid/gen)
                                   :param2 (uuid/gen)})
                          (range 10000000))))]
           (System/gc)
           tmp))
        entities (in-function
                  (stream data-file))]

    (println "DONEE" (count entities))))
