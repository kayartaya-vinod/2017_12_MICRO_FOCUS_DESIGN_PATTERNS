package co.vinod.example;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		BetterString str1 = new BetterString("Vinod");
		System.out.println(str1);
		System.out.println(str1.reverse());
		System.out.println(str1.toUpperCase());
		System.out.println(str1.substring(2));
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("Mike");
		e1.setDept("Admin");
		e1.setSalary(3000);
		
		System.out.println(e1);
		
		Employee e2 = new Employee().withId(2).withName("John"); //.withSalary(2000).withDept("Admin");
		System.out.println(e2);

	}
}


class Employee {
	int id;
	String name;
	String dept;
	double salary;
	
	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee withId(int id){
		this.id = id;
		return this;
	}
	public Employee withName(String name){
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}

	
}

class BetterString {
	private String string;

	public BetterString(String string) {
		this.string = string;
	}

	public String reverse() {
		return new StringBuffer(string).reverse().toString();
	}

	@Override
	public String toString() {
		return string.toString();
	}

	public IntStream chars() {
		return string.chars();
	}

	public IntStream codePoints() {
		return string.codePoints();
	}

	public int length() {
		return string.length();
	}

	public boolean isEmpty() {
		return string.isEmpty();
	}

	public char charAt(int index) {
		return string.charAt(index);
	}

	public int codePointAt(int index) {
		return string.codePointAt(index);
	}

	public int codePointBefore(int index) {
		return string.codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex) {
		return string.codePointCount(beginIndex, endIndex);
	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return string.offsetByCodePoints(index, codePointOffset);
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		string.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return string.getBytes(charsetName);
	}

	public byte[] getBytes(Charset charset) {
		return string.getBytes(charset);
	}

	public byte[] getBytes() {
		return string.getBytes();
	}

	public boolean equals(Object anObject) {
		return string.equals(anObject);
	}

	public boolean contentEquals(StringBuffer sb) {
		return string.contentEquals(sb);
	}

	public boolean contentEquals(CharSequence cs) {
		return string.contentEquals(cs);
	}

	public boolean equalsIgnoreCase(String anotherString) {
		return string.equalsIgnoreCase(anotherString);
	}

	public int compareTo(String anotherString) {
		return string.compareTo(anotherString);
	}

	public int compareToIgnoreCase(String str) {
		return string.compareToIgnoreCase(str);
	}

	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return string.regionMatches(toffset, other, ooffset, len);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		return string.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}

	public boolean startsWith(String prefix, int toffset) {
		return string.startsWith(prefix, toffset);
	}

	public boolean startsWith(String prefix) {
		return string.startsWith(prefix);
	}

	public boolean endsWith(String suffix) {
		return string.endsWith(suffix);
	}

	public int hashCode() {
		return string.hashCode();
	}

	public int indexOf(int ch) {
		return string.indexOf(ch);
	}

	public int indexOf(int ch, int fromIndex) {
		return string.indexOf(ch, fromIndex);
	}

	public int lastIndexOf(int ch) {
		return string.lastIndexOf(ch);
	}

	public int lastIndexOf(int ch, int fromIndex) {
		return string.lastIndexOf(ch, fromIndex);
	}

	public int indexOf(String str) {
		return string.indexOf(str);
	}

	public int indexOf(String str, int fromIndex) {
		return string.indexOf(str, fromIndex);
	}

	public int lastIndexOf(String str) {
		return string.lastIndexOf(str);
	}

	public int lastIndexOf(String str, int fromIndex) {
		return string.lastIndexOf(str, fromIndex);
	}

	public String substring(int beginIndex) {
		return string.substring(beginIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return string.substring(beginIndex, endIndex);
	}

	public CharSequence subSequence(int beginIndex, int endIndex) {
		return string.subSequence(beginIndex, endIndex);
	}

	public String concat(String str) {
		return string.concat(str);
	}

	public String replace(char oldChar, char newChar) {
		return string.replace(oldChar, newChar);
	}

	public boolean matches(String regex) {
		return string.matches(regex);
	}

	public boolean contains(CharSequence s) {
		return string.contains(s);
	}

	public String replaceFirst(String regex, String replacement) {
		return string.replaceFirst(regex, replacement);
	}

	public String replaceAll(String regex, String replacement) {
		return string.replaceAll(regex, replacement);
	}

	public String replace(CharSequence target, CharSequence replacement) {
		return string.replace(target, replacement);
	}

	public String[] split(String regex, int limit) {
		return string.split(regex, limit);
	}

	public String[] split(String regex) {
		return string.split(regex);
	}

	public String toLowerCase() {
		return string.toLowerCase();
	}

	public String toUpperCase() {
		return string.toUpperCase();
	}

	public String trim() {
		return string.trim();
	}

	public char[] toCharArray() {
		return string.toCharArray();
	}

	public String intern() {
		return string.intern();
	}

}
