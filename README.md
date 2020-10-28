# best-package

[![CircleCI](https://circleci.com/gh/rslvn/best-package.svg?style=svg)](https://circleci.com/gh/rslvn/best-package)
[![Coverage Code](https://sonarcloud.io/api/project_badges/measure?project=rslvn_best-package&metric=coverage)](https://sonarcloud.io/dashboard?id=rslvn_best-package)
[![Lines Of Code](https://sonarcloud.io/api/project_badges/measure?project=rslvn_best-package&metric=ncloc)](https://sonarcloud.io/dashboard?id=rslvn_best-package)
[![Technical Debit](https://sonarcloud.io/api/project_badges/measure?project=rslvn_best-package&metric=sqale_index)](https://sonarcloud.io/dashboard?id=rslvn_best-package)


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

