import Http
import Html exposing (..)
import Html.Attributes exposing (..)
import Json.Decode as Decode
import Html.Events exposing (..)



main =
  Html.program
    { init = init "dogs"
    , view = view
    , update = update
    , subscriptions = subscriptions
    }

type alias Model =
  { content : String }


init : String -> (Model, Cmd msg)
init topic =
  ( Model topic, Cmd.none )

type Msg
  = Add
  | NewContent (Result Http.Error String)
  | Title
  | SetOne


update : Msg -> Model -> (Model, Cmd Msg)
update msg model =
  case msg of
    SetOne ->
      (Model "1", Cmd.none)

    add ->
      (model, getBody )

    Title ->
      (model, getTitle )

    NewContent (Ok newUrl) ->
      (Model newUrl, Cmd.none)

    NewContent (Err _) ->
      (Model "456", Cmd.none)

w : Model -> Html Msg
view model =
  div []
    [ h2 [] [text model.content]
    , button [ onClick Add ] [ text "Get body" ]
    , button [ onClick Title ] [ text "Get title" ]
    , button [ onClick SetOne ] [ text "Set head to one" ]
    ]

subscriptions : Model -> Sub Msg
subscriptions model =
  Sub.none

getBody : Cmd Msg
getBody =
  let
    url =
        "https://jsonplaceholder.typicode.com/posts/1"
  in
    Http.send NewContent (Http.get url decodeGifUrl)


decodeGifUrl : Decode.Decoder String
decodeGifUrl =
  Decode.at ["body"] Decode.string

getTitle : Cmd Msg
getTitle =
  let
    url =
        "https://jsonplaceholder.typicode.com/posts/1"
  in
    Http.send NewContent (Http.get url decodeGifUrl2)

decodeGifUrl2 : Decode.Decoder String
decodeGifUrl2 =
  Decode.at ["title"] Decode.string
