
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.*
import react.*
import react.dom.*

external interface AppState: RState {
    var headers: Headers?
}

private val client = HttpClient {
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        headers = null

        val mainScope = MainScope()
        mainScope.launch {

            val r = client.post<HttpResponse>("http://localhost:8081/api/v1/create")
            r.headers.forEach { key, list ->
                println("$key: $list")
            }

            setState {
                headers = r.headers
            }
        }
    }

    override fun RBuilder.render() {
        div {
            h1 {
                +"Response headers:"
            }
            state.headers?.forEach { key, list ->
                p {
                    +"$key: $list"
                }
            }
        }
    }
}
