# KMM-Practice
KMMを触ってみる

# KMMの基礎
https://kotlinlang.org/docs/multiplatform-mobile-understand-project-structure.html#root-project

# iOSビルドエラー
M2 MacでiOSのビルドをしたときに下記のエラーが発生
```
The operation couldn’t be completed. Unable to locate a Java Runtime.
Javaのランタイムが見つからない
```
下記の記事を参考にJDKをインストール.  
https://zenn.dev/osuzuki/articles/b41dc7be15e2b5
### JDKインストール結果
![スクリーンショット 2022-07-10 21 48 29](https://user-images.githubusercontent.com/26019387/178145837-e0b95dbd-c8e0-4ea7-b413-83559fb1a34f.png)
```
$ java -version
openjdk version "18.0.1" 2022-04-19
OpenJDK Runtime Environment Zulu18.30+11-CA (build 18.0.1+10)
OpenJDK 64-Bit Server VM Zulu18.30+11-CA (build 18.0.1+10, mixed mode, sharing)
```
