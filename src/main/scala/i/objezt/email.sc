class Email(val username: String, val domainName: String){

  def tonta:Boolean =
    Email.fromString(s"${username}" + "@" + s"${domainName}")==this
}

object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split('@') match {
      case Array(user, domain) =>
        Some(new Email(user, domain))
      case _ =>
        None
    }
  }
}

val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")

scalaCenterEmail match {
  case Some(email) =>
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """
  case None => "Error: could not parse email"
}

val scalaCenterEmail2 = Email.fromString("scala.center*epfl.ch")
scalaCenterEmail2 match {
  case Some(email) =>
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """
  case None => "Error: could not parse email"
}