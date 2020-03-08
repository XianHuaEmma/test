# [Java中Collections.sort()排序详解](https://www.cnblogs.com/learnapi/p/9003112.html)

https://www.cnblogs.com/learnapi/p/9003112.html

```java
public static void main(String[] args) {
　　List<String> list = new ArrayList<String>();
　　list.add("beijing");
　　list.add("shanghai");
　　list.add("hangzhou");
　　Collections.sort(list, new Comparator<String>() {
　　　　　　public int compare(String str1, String str2) {

　　　　　　/**

- 升序排的话就是第一个参数.compareTo(第二个参数);
  降序排的话就是第二个参数.compareTo(第一个参数);
  　　　　　　*/

　　　　　　// 按首字母升序排
　　　　　　// return str1.compareTo(str2);
　　　　　　// 按第二个字母升序排
　　　　　　char c1 = str1.charAt(1);
　　　　　　char c2 = str2.charAt(1);
　　　　　　return c1 - c2;
　　　　}
　　});


```



```java
public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String temp : words) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<String> list = new ArrayList(map.keySet());
        // 升序排列
        Collections.sort(list, (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return list.subList(0, k);
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String temp : words) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        //降序排列
        PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for (String temp : map.keySet()) {
            heap.offer(temp);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }
```

### 桶排序

```
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //由于arr1的可能取值为0-1000，共1001个取值，不算一个很大的取值范围，所以可以利用桶式排序
        int[] bucket = new int[1001];
        //计数每个桶有多少个数，也就是每个值在数组中有几个
        for(int num:arr1){
            bucket[num]++;
        }
        //由于重新排序不会改变数组的长度，所以可以利用原数组，可以节省空间复杂度
        int i = 0;
        //由于排序是按照相对顺序进行排序，所以，首先根据arr2中的桶的顺序，依次从对应的桶中取数到arr1中
        //并注意，每拿出一个数，需要将对桶中的数的个数进行-1操作
        for(int num:arr2){
            while(bucket[num]-- > 0){
                arr1[i++] = num;
            }
        }
        //未在arr2中的桶中的数，按照桶号升序进行输出，所以进行二次遍历
        for(int j = 0; j < 1001; ++j){
            while(bucket[j]-- > 0){
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}

作者：edwardmartin
链接：https://leetcode-cn.com/problems/relative-sort-array/solution/java-tong-shi-pai-xu-ji-shu-pai-xu-shuang-100-by-e/

```

