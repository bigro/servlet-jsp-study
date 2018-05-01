# servlet-jsp-study
サーブレットとJSPのお勉強。

[ドキュメント](https://docs.oracle.com/javaee/7/tutorial/servlets.htm#BNAFD)

## サーブレットとは
サーブレットは、要求応答プログラミングモデルによってアクセスされるアプリケーションをホストするサーバーの機能を拡張するために使用されるJavaプログラミング言語クラスです。

サーブレットはあらゆるタイプの要求に応答できますが、Webサーバーによってホストされるアプリケーションを拡張するために一般的に使用されます。 そのようなアプリケーションの場合、Javaサーブレット技術はHTTP固有のサーブレットクラスを定義します。

javax.servletパッケージとjavax.servlet.httpパッケージは、サーブレットを記述するためのインタフェースとクラスを提供します。 すべてのサーブレットはライフサイクルメソッドを定義するサーブレットインタフェースを実装する必要があります。 ジェネリックサービスを実装する場合、JavaサーブレットAPIで提供されるGenericServletクラスを使用または拡張できます。 HttpServletクラスは、HTTP固有のサービスを処理するためのメソッド（doGetやdoPostなど）を提供します。
