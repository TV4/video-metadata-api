Behov
=====
Behovet är att i klienter enkelt hämta en bild enligt en given logik som gäller för samtliga klienter.

En asset ska per “type” kunna ha en standardbild (språk = xx, “” eller null), samtidigt som det ska kunna finna språkanpassade bilder för ett eller flera språk.

Import vs export
================
Import och export skiljer sig åt i det avseende att man vill skicka in alla bilder som finns tillgängliga till EMP för att ge redaktör möjlighet att ändra och byta bild, medan man i exporten till klient endast är intresserade av den bild (per typ och språk) som redaktör valt att publicera.
Samtidigt ska det finnas en enkel regler för att mappa import mot export i EMP

Fält per bild i EMP
===================
Image URL
image thumb URL
Orientation?
Height
Width
unit (default = px)
Type (/purpose)
Priority (lower means higher)

Språk saknas i listan ovan, men antas kunna läggas till eller samlagras med “type” attributet.
Language: { ""/null, sv, nb, dk, fi }

Dessa visas EMP i en listvy med kolumner antas vara som angetts ovan, med antagandet att det finns språkstöd.

Exportformat
============
Någonstans mellan VCMS och klient behöver logik finnas för att gruppera bilder per typ och prio (i nuläget är endast prio 1) av intresse i klienterna.

Mappning för gruppering kan görs i integrationslager i EMP eller i mottagande applikation, dvs. OVP Search Import.

TV4 önskar att att logik görs i integrationslagret i EMP, för att kunna återanvändas vid export till andra mottagare som t.ex. Youtube, KB. (Som i annat fall själva måste implementera denna logik). Antagandet är att det enklast hanteras vid export jämfört med än att sprida logik  för grupperingen till respektive mottagande system.

Logik för export från EMP/CVCMS
===============================
 - Per definierad bildtyp: landsacpe, poster, cinemascope, logoHomeTeam, logoAwayTeam
 - För bilder av samma typ och samma prio (från 1 stigande) skapa följande gruppering (se exemple XML nedan)
   o default = bild utan språk eller med språket “xx” (kan var null)
   o localizations = lista på språkanpassade bilder (samma typ och samma prio). Finns flera bilder med samma prio och språk så skickas de med som de är.  (kan vara en tom lista)



XSD förslag
===========
https://github.com/TV4/video-metadata-api/blob/image-refactorisation/src/main/xsd/export/images-alt6.xsd

Exemple XML
===========
https://github.com/TV4/video-metadata-api/blob/image-refactorisation/src/main/xsd/export/images-alt6.xsd.xml

