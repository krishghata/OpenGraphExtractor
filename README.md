# Open Graph Extractor

The Open Graph protocol enables any web page to become a rich object in a social graph. For instance, this is used on Facebook to allow any web page to have the same functionality as any other object on Facebook.

While many different technologies and schemas exist and could be combined together, there isn't a single technology which provides enough information to richly represent any web page within the social graph. The Open Graph protocol builds on these existing technologies and gives developers one thing to implement. Developer simplicity is a key goal of the Open Graph protocol which has informed many of the technical design decisions.


###To use this on your project

Add below maven dependencies:
```
<dependency>
    <groupId>in.eightfolds</groupId>
    <artifactId>OpenGraphExtractor</artifactId>
    <version>1.0.1</version>
</dependency>
```

also need to add below repository: 
```
<repository>
    <id>open-graph-extractor-mvn-repo</id>
    <url>https://github.com/krishghata/OpenGraphExtractor/raw/mvn-repo/</url>
    <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
    </snapshots>
</repository>
```
