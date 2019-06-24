# best-package

The app uses [Dynamic_programming_in-advance_algorithm](https://en.wikipedia.org/wiki/Knapsack_problem#Dynamic_programming_in-advance_algorithm) to solve the packing problem
    
## prerequisites
- JDK1.8
- gradle

## test
    gradle test

- Code coverage: `%90` with main class, `%100` without main class.
- Case coverage: `%100`

## build
    gradle clean build

## run
    java -jar build/libs/best-package-1.0.jar <filePath>
    
##### sample
    java -jar build/libs/best-package-1.0.jar src/test/resources/PackageProblem.txt