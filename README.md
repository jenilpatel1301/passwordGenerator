# passwordGenerator #

This is a Java program that generates a random password of a specified length. The generated password includes a mix of lowercase and uppercase letters, numbers, and special characters.

## Usage

The program can be run from the command line or from an IDE like IntelliJ. To run the program from the command line, navigate to the directory containing the PasswordGenerator.java file and enter the following command:

```bash
javac PasswordGenerator.java
java PasswordGenerator
```

This will compile and run the program, which will generate a password and output it to the console.

To specify the length of the generated password, modify the passwordLength variable in the main method. The default value is 12 characters.

## Implementation Details

The program uses a SecureRandom object to generate random numbers, which are used to select random characters from the set of allowed characters. The program first selects one character from each of the sets of lowercase letters, uppercase letters, numbers, and special characters, and then fills the rest of the password with random characters from the full set of allowed characters. Finally, the program shuffles the characters in the password to ensure that the order is random.

## License

This code is licensed under the MIT License. Feel free to use it however you like!



