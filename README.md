# IOSR2015-real-estate-broker
Projekt na przedmiot IOSR. Aplikacja rozproszona do handlu nieruchomościami umożliająca dodawania posiadłości na sprzedać jak i klientów (kupców) zainteresowanych kupieniem domu/mieszkania.

## instalacja na Karaf (jeszcze nie udało się uruchomić)
* Należy pobrać i wypakować Apache Karaf: http://karaf.apache.org/index/community/download.html - przetestowane na wersji 2.4.1, na innych mogą być inne komendy, więc polecam tę, ewentualnie inną 2.4.x
* W pliku ```etc/org.apache.karaf.features.cfg``` edytujemy dwie linie, tak by wyglądały następująco:
```
featuresRepositories = mvn:org.apache.karaf.assemblies.features/standard/2.4.1/xml/features,mvn:org.apache.karaf.assemblies.features/spring/2.4.1/xml/features,mvn:org.apache.karaf.assemblies.features/enterprise/2.4.1/xml/features,mvn:org.apache.felix.karaf/apache-felix-karaf/1.4.0/xml/features,mvn:org.apache.camel.karaf/apache-camel/2.15.1/xml/features,jar:mvn:pl.edu.agh.iosr/realestatebroker.features/1.0-SNAPSHOT!/features.xml
featuresBoot = karaf-framework,shell,features,service-security,admin,config,ssh,management,kar,deployer,diagnostic,spring,spring-dm,camel,camel-jms,activemq,activemq-camel,camel-cxf,my-cxf,hibernate,jdbc-driver,realestatebroker
```
* W pliku ```system.properties``` dodajemy linię:
```
servicemix.base=root
```
* Wykonujemy na projekcie ```mvn install```
* Uruchamiamy Karafa: ```bin/karaf```
* Projekt zostanie automatycznie zainstalowany z niezbędnymi zależnościami (niestety jeszcze nie wszystkie zależności udało mi się rozwiązać)