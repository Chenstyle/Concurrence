# 习题

1.在不同的卡片上分别写下数字1到100，打乱后按顺序进行排序。
代码：
```Java
for (int i = 0; i < 100; i++) {
    for (int j = i; j < 100; j++) {
        if (arr2[i] > arr2[j]) {
            int temp = arr2[i];
            arr2[i] = arr2[j];
            arr2[j] = temp;
        }
    }
}
```
简单的排序，这里用的冒泡。
