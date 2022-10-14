function clearSessionCookie() {
    if (document.cookie.length !== 0) {
        document.cookie += "JSESSIONID" + ";max-age=0"
    } else {
        console.log("cookie is  null")
    }

}