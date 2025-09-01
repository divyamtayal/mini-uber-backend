## to create jwt token 
mvn -q -DskipTests \                                    
-Dexec.mainClass=com.miniuber.gateway.util.DevJwtMaker \
-Dexec.args="MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5MDE= user-123" \
org.codehaus.mojo:exec-maven-plugin:3.1.0:java

