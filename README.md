

# Running 
```
./run.sh :num 10000000   :gen "[:param1 :param2]:" :parse  "[:param1 :param2]"
```

## Result
```
START Prparing; memory(mb): 66
Preparing 10000000 [:param1 :param2] [:param1 :param2]
END Prparing; elapsed(msec): 5.874394; memory(mb): 66 -> 68
START Creating data; memory(mb): 68
START Writing commands to local temporary file; memory(mb): 68
END Writing commands to local temporary file; elapsed(msec): 6349.56772; memory(mb): 68 -> 15
START Gziping data; memory(mb): 15
START Gzipping data file; memory(mb): 14
END Gzipping data file; elapsed(msec): 26610.638684; memory(mb): 14 -> 15
END Gziping data; elapsed(msec): 26635.020224; memory(mb): 15 -> 15
END Creating data; elapsed(msec): 32997.208623; memory(mb): 68 -> 15
START Loading data; memory(mb): 15
END Loading data; elapsed(msec): 14534.284271; memory(mb): 15 -> 2207
DONEE 10000000

```

## Memory usage after read 
2.2GB



# Running 
```
./run.sh :num 10000000   :gen "[:param1 :param2]:" :parse  "[:param1]"

```

## Result
```
START Prparing; memory(mb): 64
Preparing 10000000 [:param1 :param2] [:param1]
END Prparing; elapsed(msec): 6.76888; memory(mb): 64 -> 66
START Creating data; memory(mb): 66
START Writing commands to local temporary file; memory(mb): 66
END Writing commands to local temporary file; elapsed(msec): 6609.479859; memory(mb): 66 -> 15
START Gziping data; memory(mb): 15
START Gzipping data file; memory(mb): 14
END Gzipping data file; elapsed(msec): 27622.975221; memory(mb): 14 -> 15
END Gziping data; elapsed(msec): 27646.918494; memory(mb): 15 -> 15
END Creating data; elapsed(msec): 34274.908073; memory(mb): 66 -> 15
START Loading data; memory(mb): 15
END Loading data; elapsed(msec): 12781.771951; memory(mb): 15 -> 1368
DONEE 10000000

```


## Memory usage after read 
1.3GB



