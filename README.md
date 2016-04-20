video-metadata-api
================

<!--
// Documentation
// Regular markdown specification: http://daringfireball.net/projects/markdown/
// Blueprint dialect used to create REST API markdown: http://apiary.io/blueprint
// Eclipse plugin for syntax hilight and HTML preview: https://github.com/winterstein/Eclipse-Markdown-Editor-Plugin
-->

_**Current status**
Further development is put on pause from TV4 side as of April 2016 due to a retake of the OVP initiatives 
and reorganization of TV4 and C More._

# Background
XML schema for metadata messages imported to EMP.
THe XML format is based on TV4 and SVT common format for distribution to (since 2015 maintained by June. URL: http://www.june.se/en/public-schedule)

This format was choose as it was an established local standard, used in production at the time (Q4 2014). 
In addition Ericsson did not propose an alternative for EMP. CableLabs metadata specifications were discused but lacks some features needed in one single format. (http://www.cablelabs.com/specs/)


**Evolution**
The first change was the addition of the REST API endpoints.

Second major change was the split of the single format into an import and an export format.

After that there has been several continuous changes into the current format.

# REST API _<- outdated!_
The rest API is described in [docs/blueprint.md](docs/blueprint.md)


# XML messages XSD
The rest API is described here: [src/main/xsd](src/main/xsd)

**Branches**

The code is maintained in TV4 GitHub repo (which is the location of this README file).

The three branches are:
 - master - production version of the XSD
 - stage - stage version of the XSD
 - develop - local dev version
 - specification - architect branch used to hold all future specification changes not possible to handel in develop
 
  



