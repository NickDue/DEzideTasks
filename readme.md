# General info:
This is my take on the two assignment given by DEzide when applying for a student developer job.
The source code is written in Java.

# Build info:
**Build tool** = Gradle  
**JDK**  = OpenJDK 17

#How to run
First, go into the build.gradle file, and run the **jar** task.

Next, open a terminal in the root of this repo.  
The source code has been packed into a .jar file, and can be run with the following command:  
>java -jar /build/libs/costconverter.jar *parameters*.

The three required parameters are:  
1. Time in minutes
2. Amount of money
3. Model name

It is also possible to add custom parameters. The currently custom parameters supported are:
- inconvenience
- risk

And these parameters can have the values:
- None
- Low
- Medium
- High

To input a custom paramter used the following syntax:
> identifier:value // pseudo example  
> inconvenience:low risk:high // practical example

The order of the custom parameters does not matter.
