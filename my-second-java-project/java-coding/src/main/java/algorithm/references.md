[华为牛客网机试题](https://www.nowcoder.com/exam/oj/ta?tpId=37)

[PAT牛客网练习场](https://www.nowcoder.com/pat)



素数: 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）

素数的判断方式: 如果一个数, 从2到其平方根都无法被整除, 则此数为素数.

输入: Java统一使用BufferedReader+InputStreamReader封装System.in来实现输入, 并使用readLine().split(" ")方法来获取一行中的数据. 
如果输入的是数字, 则统一使用对应的封装类的parse*方法转换字符串为数值, 如: Integer.parseInt(str).

输出: Java统一使用StringBuilder拼接字符串批量输出


常用API:
String.charAt
String.format()
String.valueOf
String.valueOf(char data[])
String.valueOf(char data[], int offset, int count)
Character.isAlphabetic
Double.compare()
Arrays.sort()
Arrays.sort(Comparator)
Arrays.sort(fromIndex, toIndex, Comparator)

注意事项:
1. 注意边界条件, 多使用注释来标明循环跳出时的变量值
2. 注意ASCII表, 需要记住数字类字符, 和大小写字母类字符的相对位置
3. 注意多写注释, 避免逻辑死循环, 或者遗忘
4. 读题时, 要用符号做笔记, 避免后续反复读题, 如排序条件 sort (a+b DESC, a DESC, num ASC)等
5. 大道至简, 编程竞赛就是仅解决当前问题, 不要求程序的扩展性和鲁棒性

编程原则:
1. 输入参数不变原则, 统一不改变输入参数, 若要将其修改后使用, 需先进行拷贝