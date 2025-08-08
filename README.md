# KATA - TIC TAC TOE

## RULES

The rules are described below :

-X always goes first.
-Players cannot play on a played position.
-Players alternate placing X’s and O’s on the board until either:
  -> One player has three in a row, horizontally, vertically or diagonally
  -> All nine squares are filled.
- If a player is able to draw three X’s or three O’s in a row, that player wins.
- If all nine squares are filled and neither player has three in a row, the game is a draw.

link => https://github.com/stephane-genicot/katas/blob/master/TicTacToe.md

## GIT

I use Github because I know it and it seems correct for this exercice
I try to apply the Gitflow workflow :
- the main branch 
- the develop branch
- the feature branches
- the release branches
- tag for the version

## TDD
I never use TDD in project, I read some articles before my exercice ans ask questions about TDD.
I tried to apply TDD on the project by respecting the principle : RED - GREEN - REFACTOR 

## Architecture

### Clean Architecture
I tried to apply clean Architecture with different layers : UI - DATA - DOMAIN
Layer Domain
 - entities
 - use cases

Layer Data
 - in this case is empty, we can save the state of game if it was a requirement

Layer Presentation/UI
 - handle the interaction with UI

## Layer Presentation/UI
...

### Principles
I tried to apply the SOLID principles.


## Install

### Github
clone the project https://github.com/wizard112/2025-DEV2-008-MyTicTacToe.git

### IDE
Android Studio Narwhal Feature Drop - 2025.1.2
Upgrade to Gradle 8.14.3
JAVA VERSION / Gradle JDK : 21.0.6
minimum version is 9 (Pie) - API Level is 28
target SDK and compile SDK is 36

### Language
Koltin version 2.2.0



## Sources
Gitflow workflow : https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow
clean architecture blog - uncle bob : https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
conventional commit : https://medium.com/@noriller/docs-conventional-commits-feat-fix-refactor-which-is-which-531614fcb65a
example project clean architecture with MVI : https://medium.com/@sharmapraveen91/mastering-mvi-clean-architecture-for-android-a-comprehensive-guide-with-clean-code-and-tdd-best-98272fabe4f2
Examples README for Android project : https://gist.github.com/framundo/fb7d75a0176f7be2b02e
Kotlin Doc sequence - any : https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/any.html
Kotlin collections : https://kotlinlang.org/docs/collections-overview.html
