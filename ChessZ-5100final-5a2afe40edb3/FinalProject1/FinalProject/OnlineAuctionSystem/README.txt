This project needs to be implemented with following environments:

JDK 1.8 - JAVA environment
Tomcat 7.0 - web server
Microsoft SQL Server - database

With environments configered, follow the steps to config Tomcat SSL:
1. 	Use key tool to generate certification file:
	run cmd.exe
	input: 
	 >keytool -genkey -alias tomcat -keyalg RSA -keysize 1024 -validity 365 -keystore tomcat.keystore 
	which will generate tomcat.keystore, remember the password(suppose it is 123456)

2.	Cut the tomcat.keystore under path: TOMCAT/conf

3.	Edit server.xml file:
	find SSL Connector comments and paste as follows:

<!-- Define an SSL HTTP/1.1 Connector on port 8443 --> 
 <Connector    
  port="8443" maxHttpHeaderSize="8192"
  maxThreads="150" minSpareThreads="25"
  maxSpareThreads="75"
  enableLookups="false"
  disableUploadTimeout="true"
  acceptCount="100" scheme="https"
  secure="true"
  clientAuth="false" sslProtocol="TLS"
  keystoreFile="conf/tomcat.keystore"
  keystorePass="123456" /> 

4.	Restart TOMCAT, enter"http://localhost:11061/Auction/Login.aspx" to start running