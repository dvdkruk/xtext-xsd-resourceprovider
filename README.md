# xtext-xsd-resourceprovider
Two projects to make XSD references possible in your Xtext grammar. This project uses the concepts explained in https://christiandietrich.wordpress.com/2011/07/17/xtext-2-0-and-uml/.

## Tech
- Java 8
- Xtext
- Eclipse XML Schema Editor

## How To Use
- Import the __org.eclipse.xtext.xsd__ and __org.eclipse.xtext.xsd.ui__ projects into your workspace.
- Add the following required bundles to the __MANIFEST.MF__ of your core Xtext DSL project:
```
org.eclipse.xtext.xsd,
org.eclipse.xtext.xsd.ui,
org.eclipse.xsd
```
- Add the following lines to your .mwe2 generate file:
```ruby
Workflow {
  bean = org.eclipse.emf.mwe.utils.StandaloneSetup {
    scanClassPath = true
    platformUri = rootPath
    registerGeneratedEPackage = "org.eclipse.xsd.XSDPackage"
    registerGenModelFile = "platform:/resource/org.eclipse.xsd/model/XSD.genmodel"
  }
}
```
- Add the following import to your Xtext grammar file (.xtext):
```ruby
import "http://www.eclipse.org/xsd/2002/XSD" as xsd
```
__Note:__ Imports should be added between the grammar and generate declarations.
- Now your Xtext DSL can reference to elements defined in XSD files. For example, the following rule is now possible:
```ruby
TypeInstance:
  'instance' name=ID ':' type=[xsd::XSDTypeDefinition|QN];
  
QN:
  ID ('.' ID)*;
```
