// funcion nominal
def concatenator1(preffix: String, suffix: String): String =
  preffix + " " + suffix

concatenator1("Hi, ", "Luis")
concatenator1("Hi, ", "Paula")
concatenator1("Bye, ", "Luis")
concatenator1("Bye, ", "Paula")

// funcion anónima
((preffix: String, suffix: String) => preffix + " " + suffix) ("Hi, ", "Luis")
((preffix: String, suffix: String) => preffix + " " + suffix) ("Hi, ", "Paula")
((preffix: String, suffix: String) => preffix + " " + suffix) ("Bye, ", "Luis")
((preffix: String, suffix: String) => preffix + " " + suffix) ("Bye, ", "Paula")

def concatenator2 = (preffix: String, suffix: String) => preffix + " " + suffix
concatenator2("Hi, ", "Luis")
concatenator2("Hi, ", "Paula")
concatenator2("Bye, ", "Luis")
concatenator2("Bye, ", "Paula")

// función de retorno:clousure
def concatenator3(preffix: String): String => String =
  (suffix: String) => preffix + " " + suffix

def greeting3 = concatenator3("Hi,")
greeting3("Luis")
greeting3("Paula")
def dismissal3 = concatenator3("Bye,")
dismissal3("Luis")
dismissal3("Paula")

// aplicación parcial
def greeting4 = concatenator1("Hi,", _: String)
greeting4("Luis")
greeting4("Paula")

def dismissal4 = concatenator1("Bye,", _: String)
dismissal4("Luis")
dismissal4("Paula")

def greeting5 = concatenator2("Hi,", _: String)
greeting5("Luis")
greeting5("Paula")

def dismissal5 = concatenator2("Bye,", _: String)
dismissal5("Luis")
dismissal5("Paula")

// currificación
def concatenator6(preffix: String)(suffix: String): String =
  preffix + " " + suffix

concatenator6("Hi,")("Luis")
concatenator6("Hi,")("Paula")
concatenator6("Bye,")("Luis")
concatenator6("Bye,")("Paula")

def greeting6 = concatenator6("Hi,") _
greeting6("Luis")
greeting6("Paula")

def dismissal6 = concatenator6("Bye,") _
dismissal6("Luis")
dismissal6("Paula")

(concatenator1 _).curried
(concatenator1 _).curried("Hi,")
(concatenator1 _).curried("Hi,")("Luis")
((concatenator1 _).curried (_:String) ("Luis"))("Hi,")



