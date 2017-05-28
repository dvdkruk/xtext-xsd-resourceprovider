# xtext-xsd-resourceprovider
Two projects to make XSD references possible in your Xtext grammar. This project uses the concepts explained in https://christiandietrich.wordpress.com/2011/07/17/xtext-2-0-and-uml/.

## Tech
- Java 8
- Xtext
- Eclipse XML Schema Editor

## How To Use
- Import __org.eclipse.xtext.xsd__ and __org.eclipse.xtext.xsd.ui__ into your workspace. 
- Add the following lines to the __StandaloneSetup__ in your .mwe2 file:
```ruby
registerGeneratedEPackage = "org.eclipse.xsd.XSDPackage"
registerGenModelFile = "platform:/resource/org.eclipse.xsd/model/XSD.genmodel"
```
- Add the following line to your Xtext grammar file (.xtext):
```ruby
import "http://www.eclipse.org/xsd/2002/XSD" as xsd
```
- Now your Xtext can use references to elments defined in XSD files. For example the following rule is now possible:
```ruby
TypeInstance:
  'instance' name=ID ':' type=[xsd::XSDTypeDefinition|QN];
  
QN:
  ID ('.' ID)*;
```
