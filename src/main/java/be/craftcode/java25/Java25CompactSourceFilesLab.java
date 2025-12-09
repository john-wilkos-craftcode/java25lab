/// # [JEP 512](https://openjdk.org/jeps/512): Compact Source Files and Instance Main Methods
///
/// Java 25 lets us prototype with an implicit class and top-level `void main()`.
/// Much less intimidating and easier to use.
///
/// ## *Notice anything missing?*
/// Before, you would have had to write all this boilerplate:
/// ```java
/// package be.craftcode.java25;
/// 
/// import java.util.Scanner;
/// 
/// public class HelloWorld {
/// 
///     public static void main(String[] args){
///
///        Scanner scanner = new Scanner(System.in);
///
///        System.out.print("Please enter your name: ");
///        String name = scanner.nextLine();
///
///        System.out.print("Pleased to meet you, ");
///        System.out.println(name);
///
///        scanner.close();
///     }
/// }
/// ```
/// Now, a simple `void main(){ }` is all you need! Also, the new IO package has your IN and OUT needs covered.
///
void main() {
    String name = IO.readln("Please enter your name: ");
    IO.print("Pleased to meet you, ");
    IO.println(name);
}