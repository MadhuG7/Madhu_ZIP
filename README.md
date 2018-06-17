# Project Title:

Madhu_ZIP_Range
zip-range A project to accept zip code range from user and produce the minimum number of ranges required to represent the the input.

## Getting Started:

BACKGROUND Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. 

### Example:

If the ranges are:
<>[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

###PROBLEM:

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

###Extra Input: 

The ranges above are just examples, your implementation should work for any set of arbitrary ranges
Ranges may be provided in arbitrary order
Ranges may or may not overlap
Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

### EXAMPLES: 

If the input <>[94133,94133] [94200,94299] [94600,94699] Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] Then the output should be = [94133,94133] [94200,94399]

### Prerequisites:

Eclipse
Java Environment
Maven 
Relavant Libraries 

Building Maven is used for building the source code.

### Execution:
For executing the application, 

run: mvn exec:java Maven will compile the test cases and source code. It will wait for user to supply input. Sample input can be [49679,52015] [49800,50000] [51500,53479] [45012,46937] The application will then display the minimum number of ranges required.

Test Use mvn test to run the test cases. Surefire reports are generated inside target/surefire-reports folder.

Javadoc Use mvn javadoc:javadoc to generate javadoc for the project. The javadoc will be generated inside target/site folder.

###Libraries: 

junit 4.12 - Unit testing framework junit-dataprovider 1.10.0 - JUnit dataprovider framework to supply input to test cases log4j 1.2.17 - Library for logging
