[华为牛客网机试题](https://www.nowcoder.com/exam/oj/ta?tpId=37)

[PAT牛客网练习场](https://www.nowcoder.com/pat)

[浙江大学-PTA程序设计类实验辅助教学平台-实战环境模拟](https://pintia.cn/problem-sets/dashboard)


素数: 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）

素数的判断方式: 如果一个数, 从2到其平方根都无法被整除, 则此数为素数.

输入: Java统一使用BufferedReader+InputStreamReader封装System.in来实现输入, 并使用readLine().split(" ")方法来获取一行中的数据. 
如果输入的是数字, 则统一使用对应的封装类的parse*方法转换字符串为数值, 如: Integer.parseInt(str).

输出: Java统一使用StringBuilder拼接字符串批量输出


常用API:

```
java.io.BufferedReader(Reader)
java.io.BufferedReader.readLine()
java.io.InputStreamReader(InputStream)

StringBuilder

String.charAt
String.format(): 
    "%,d"表示使用逗号分隔符分组小数点左侧数字
    "%.2f"表示四舍五入保留小数点后两位
    "%,.2f"表示四舍五入保留小数点后两位, 同时使用逗号分隔符分组小数点左侧数字
String.valueOf
String.valueOf(char data[])
String.valueOf(char data[], int offset, int count)
String.split(String)

Character.isAlphabetic(int)
Integer.parseInt(String)
Double.compare(double, double)

Arrays.sort()
Arrays.sort(Comparator)
Arrays.sort(fromIndex, toIndex, Comparator)
Arrays.binarySearch(array, fromIndex, toIndex, key)
Arrays.fill(array, value)

Arrays.asList(): return a immutable list

Arrays.equals()
Arrays.deepEquals()

List.asList(): return a immutable list

```

注意事项:
1. 代码一般都是分为三个部分，处理输入和边界条件、处理逻辑、返回结果变量。
2. 输入处理，使用统一的 API 处理模式。
3. 边界条件，可以使用注释来标明循环跳出时的变量值。
4. 代码执行过程中，尽量不修改输入变量，若要将其修改则需先进行拷贝。
5. 代码出口数量需要严格限制，尽量保持代码出口唯一。
6. 注意多写注释，避免逻辑死循环，或者遗忘。
7. 注意 ASCII 表，需要记住数字类字符，和大小写字母类字符的相对位置。
8. 读题时，要摘录关键条件，避免后续反复读题，如“返回结果要求排序”、“题目有且仅有唯一解”、“输入数组有序”等等。
9. 大道至简，编程竞赛就是仅解决当前问题，禁止追求程序的扩展性和鲁棒性。