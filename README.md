# KATA - TIC TAC TOE

## RULES

The rules are described below :

- X always goes first.
- Players cannot play on a played position.
- Players alternate placing X’s and O’s on the board until either:
   - One player has three in a row, horizontally, vertically or diagonally
   - All nine squares are filled.
- If a player is able to draw three X’s or three O’s in a row, that player wins.
- If all nine squares are filled and neither player has three in a row, the game is a draw.

[Tic Tac Toe link](https://github.com/stephane-genicot/katas/blob/master/TicTacToe.md)

## GIT

I use Github because I know it and use for my own projects, and it seems correct for this exercise

### Gitflow workflow

I tried to apply the Gitflow workflow :
- the main branch : it contains the final project
- the develop branch : the features branch is created from this branch and I do the PR into this branch too
- the feature branches : it contains each new logic 
- the release branches : it contains each release, in my case there is the release 1.0
- tag for the version : I created a tag, the version 1.0


### Pull Request

I think a good idea to create a pull request for each feature branch, this process allows me
to add comment and to try improve my code from this comment.


## TDD

I never used TDD in any type of the project, I read some articles before my exercise and I ask some questions about TDD around me.
I tried to apply TDD on the project by respecting the following principle: RED - GREEN - REFACTOR 


## Architecture

### Clean Architecture
I tried to apply clean Architecture with different layers : UI - DATA - DOMAIN

#### Layer Domain

 - entities
 - use cases

##### In the Kata

 I tried to apply the principle of for one action we have only one use case
 the action play => use case Game
 the action it is turn to the player => use case Players
 the action verifier => use case Verifier


#### Layer Data
   In my implementation this layer is empty.
   We can save the state of game if it was a requirement for example.


#### Layer Presentation
 - To handle the interactions of the user from an UI.

##### Design pattern Model-View-Intent

I tried to implement the design pattern MVI in this layer. I think it is a good pattern because
this pattern uses a unidirectional data flow, separation of concerns and immutability : 

- Component Intent : the interaction and user actions like click button, it communicates the user's actions.
- Component Model : the single source of truth, it has the logic and data and it manages the state.
- Component View : the UI renderer, it displays the app's state to the user


### SOLID Principles

I tried to apply the SOLID principles in my different classes. 
Theses principles help to have a maintainable, testable and scalable project.


## Accessibility

I tried to test the accessibility in the compose UI and 
then the fix the result of the test in adding semantics to modifier of the cell.


## CI/CD

I tried to use the Github Actions for simple tasks, it is my first implementation of the actions.

- Trigger: for each pull request the action is triggered
- jobs : clean the project, build the project and then run unit test.


## Install

### Github
clone the project https://github.com/wizard112/2025-DEV2-008-MyTicTacToe.git

### IDE
- Android Studio Narwhal Feature Drop - 2025.1.2
- Upgrade to Gradle 8.14.3
- JAVA VERSION / Gradle JDK : 21.0.6
- minimum version is 9 (Pie) - API Level 28
- target SDK and compile SDK is 36

### Language
Kotlin version 2.2.0

### Build

#### Command line
- navigate to the tictactoe folder of the project
- run the command `./gradlew installDebug`
- on your device open the project MyTicTacToe

#### Android Studio
[IDE](https://developer.android.com/studio/run?hl=fr)


## Improvements

- I encountered an issue with the mutable state flow and the playing ui state, 
  the map of ui state has the same reference that the board of Game Use Case. 
  When there is a change in the board the mutable compares old value and new value 
  but it is the same because they share the same reference and the new value does not emitted by the mutable to the view. 
  I use toMap() to create a copy of the board to enforce the mutable to emit new value to the view. 
  I know it is not the best approach, need to think a more elegant and a good practice approach
- I am not ok with the conditions and loops that I use in the verifiers to check the different rows. 
  I think I mut to use the different operations of Collections to have a code more readable, easy to understand and to evolve.


## Sources
- [Gitflow workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)
- [clean architecture blog - uncle bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [conventional commit](https://medium.com/@noriller/docs-conventional-commits-feat-fix-refactor-which-is-which-531614fcb65a)
- [example project clean architecture with MVI](https://medium.com/@sharmapraveen91/mastering-mvi-clean-architecture-for-android-a-comprehensive-guide-with-clean-code-and-tdd-best-98272fabe4f2)
- [Examples README for Android project](https://gist.github.com/framundo/fb7d75a0176f7be2b02e)
- [Kotlin Doc Collections - any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/any.html)
- [Kotlin Doc collections in general](https://kotlinlang.org/docs/collections-overview.html)
- [Medium - Android Project with MVI](https://medium.com/@mohammedkhudair57/mvi-architecture-pattern-in-android-0046bf9b8a2e)
- [Accessibility - Test Compose UI & Add in UI from the result](https://developer.android.com/develop/ui/compose/accessibility/testing?hl=fr)
