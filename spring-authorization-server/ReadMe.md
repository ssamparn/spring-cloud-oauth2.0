
## Follow the steps to perform the oauth2.0 flow

#### Navigate to below website
```
https://oauthdebugger.com/
```

#### Auth token issuer:
```
http://authorization-server:9000
```

#### Authorization Endpoint:
```
http://authorization-server:9000/oauth2/authorize
```

#### Redirect URI:
```
https://oauthdebugger.com/debug
```

#### Client ID:
```
client
```

#### Scope:
```
read
```

#### Response type:
```
code
```
#### Username and password:
```
user
password
```

### Complete url for generating authorization code:
```
GET http://authorization-server:9000/oauth2/authorize
?client_id=client
&redirect_uri=https://oauthdebugger.com/debug
&scope=read
&response_type=code
&response_mode=form_post
```

#### Note: The authorization server will respond with a code, which the client can exchange for tokens on a secure channel. This flow should be used when the application code runs on a secure server. Now you need to exchange the authorization code for tokens using the token endpoint. It will involve client id and client secret to be exchanged.

#### Token Endpoint:
```
http://authorization-server:9000/oauth2/token
```
#### Redirect URI:
```
https://oauthdebugger.com/debug
```
#### Grant Type:
```
authorization_code
```
### Complete url for generating access token:
```
POST http://authorization-server:9000
Content-Type: application/x-www-form-urlencoded

grant_type=authorization_code&
code=WVVaHtubDpUzNQnrw2ByovDJ5HqzOB71nsvYd-E_FsUmbI_dBZX1-EbS11Qov4fHT7S72zeGblm_P3zLVr1CefOkw3vyW3mgHcvghTrEnLQ_tqSyOK3iVleETI_yGuXA&
client_id=client&
client_secret={clientSecret}&
redirect_uri=https%3A%2F%2Foauthdebugger.com%2Fdebug
```


#### Jwks Endpoint:
```
http://authorization-server:9000/oauth2/jwks
```
