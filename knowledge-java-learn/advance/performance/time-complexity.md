# O(1), O(n), O(logn), O(nlogn) 的区别

在描述算法复杂度时，经常用到O(1), O(n), O(logn), O(nlogn)来表示对应复杂度程度, 不过目前大家默认也通过这几个方式表示空间复杂度 。

那么，O(1), O(n), O(logn), O(nlogn)就可以看作既可表示算法复杂度，也可以表示空间复杂度。

大O加上（）的形式，里面其实包裹的是一个函数f(),O（f()）,指明某个算法的耗时/耗空间与数据增长量之间的关系。其中的n代表输入数据的量。

![](image/time-complexity1.png)

```
如果ax=N（a>0，且a≠1），那么数x叫做以a为底N的对数，记作x=logaN，读作以a为底N的对数，其中a叫做对数的底数，N叫做真数。
```

![](image/time-complexity2.png)


时间复杂度有小到大的排列：

O(1)<O(log以2为底的n)<O(n)<O(n(log以2为底的n))<O(nn)<O(nn*n)<O(2的n次方)

![](image/time-complexity3.png)