# TDD Kata in Java [![Build Status](https://travis-ci.org/WowCoach/tdd-kata-java.svg?branch=master)](https://travis-ci.org/WowCoach/tdd-kata-java)

## TDD Practice
- [TDD Practice 1 - 简单集合操作](docs/TDD1.md)
- [TDD Practice 2 - 猜数字游戏](docs/TDD2.md)

## Project Board
- [ZenHub](https://github.com/WowCoach/tdd-kata-java#boards?repos=64041285)

## How to Start
#### Clone source code
```
git clone https://github.com/WowCoach/tdd-kata-java.git
cd tdd-kata-java
```

#### Generate IntelliJ IDEA project
```
./gradlew cI idea  # Will clean idea first then idea
```

Open the `tdd-kata-java.ipr` using IntelliJ
```
open tdd-kata-java.ipr  # Using open or start depends on your OS
```

#### Run clean and build tasks
```
./gradlew  # Will run default clean build tasks
```

This will also run checkstyle, unit test and code coverage check

## Commit Standard:
```
[卡号][提交作者&Pair作者] - comment here
```

**Example:**
```
[M001][Shane&Water] - add the collection library
```

**Note:** [提交作者]和comment之间需要有`空格+minus+空格`，comment内容不要出现minus。

## Code to Notice:
- 代码中删去未使用的Import引用包，需要注意引用顺序。
- 类文件开始处不要出现 "/* xxx create xxx */" 这样自动生成的注释。
- 还有其他规范Checkstyle将会覆盖到。
