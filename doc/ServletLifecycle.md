# サーブレットのライフサイクル
サーブレットのライフサイクルは、サーブレットがデプロイされているコンテナによって制御されます。要求がサーブレットにマップされると、コンテナは次の手順を実行します。

1. サーブレットのインスタンスが存在しない場合、Webコンテナは次のようになります。
        1. サーブレットクラスをロードします。
        1. サーブレットクラスのインスタンスを作成します。
        1. initメソッドを呼び出すことによってサーブレットインスタンスを初期化します（初期化についてはサーブレットの作成と初期化を参照してください）
1. コンテナは、要求と応答オブジェクトを渡してサービスメソッドを呼び出します。サービスメソッドについては、「サービスメソッドの作成」を参照してください。

サーブレットを削除する必要がある場合、コンテナはサーブレットのdestroyメソッドを呼び出してサーブレットを終了します。詳細については、「サーブレットの完成」を参照してください。

## サーブレットライフサイクルイベントの処理
ライフサイクル・イベントが発生したときにメソッドが呼び出されるリスナー・オブジェクトを定義することにより、サーブレットのライフ・サイクル内のイベントを監視して対応することができます。これらのリスナーオブジェクトを使用するには、リスナークラスを定義して指定する必要があります。

## リスナークラスの定義
リスナークラスは、リスナーインタフェースの実装として定義します。 表17-1に、監視可能なイベントと実装する必要のある対応するインタフェースを示します。 リスナー・メソッドが呼び出されると、イベントに適切な情報を含むイベントがリスナー・メソッドに渡されます。 たとえば、HttpSessionListenerインターフェイスのメソッドには、HttpSessionを含むHttpSessionEventが渡されます。

@WebListenerアノテーションを使用して、特定のWebアプリケーションコンテキストでのさまざまな操作のイベントを取得するリスナを定義します。 @WebListenerで注釈が付けられたクラスは、次のいずれかのインタフェースを実装する必要があります。
```
javax.servlet.ServletContextListener
javax.servlet.ServletContextAttributeListener
javax.servlet.ServletRequestListener
javax.servlet.ServletRequestAttributeListener
javax.servlet..http.HttpSessionListener
javax.servlet..http.HttpSessionAttributeListener
```

たとえば、次のコードスニペットでは、これらのインターフェイスのうちの2つを実装するリスナを定義しています。
```
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class SimpleServletListener implements ServletContextListener,
        ServletContextAttributeListener {
    ...
```

## サーブレットエラーの処理
サーブレットの実行時には、いくつでも例外が発生する可能性があります。例外が発生すると、Webコンテナは次のメッセージを含むデフォルトページを生成します。
```
A Servlet Exception Has Occurred
```

ただし、コンテナが特定の例外の特定のエラーページを返すように指定することもできます。
