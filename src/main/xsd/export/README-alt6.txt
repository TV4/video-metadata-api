Behov
=====
Behovet �r att i klienter enkelt h�mta en bild enligt en given logik som g�ller f�r samtliga klienter.

En asset ska per �type� kunna ha en standardbild (spr�k = xx, �� eller null), samtidigt som det ska kunna finna spr�kanpassade bilder f�r ett eller flera spr�k.

Import vs export
================
Import och export skiljer sig �t i det avseende att man vill skicka in alla bilder som finns tillg�ngliga till EMP f�r att ge redakt�r m�jlighet att �ndra och byta bild, medan man i exporten till klient endast �r intresserade av den bild (per typ och spr�k) som redakt�r valt att publicera.
Samtidigt ska det finnas en enkel regler f�r att mappa import mot export i EMP

F�lt per bild i EMP
===================
Image URL
image thumb URL
Orientation?
Height
Width
unit (default = px)
Type (/purpose)
Priority (lower means higher)

Spr�k saknas i listan ovan, men antas kunna l�ggas till eller samlagras med �type� attributet.
Language: { ""/null, sv, nb, dk, fi }

Dessa visas EMP i en listvy med kolumner antas vara som angetts ovan, med antagandet att det finns spr�kst�d.

Exportformat
============
N�gonstans mellan VCMS och klient beh�ver logik finnas f�r att gruppera bilder per typ och prio (i nul�get �r endast prio 1) av intresse i klienterna.

Mappning f�r gruppering kan g�rs i integrationslager i EMP eller i mottagande applikation, dvs. OVP Search Import.

TV4 �nskar att att logik g�rs i integrationslagret i EMP, f�r att kunna �teranv�ndas vid export till andra mottagare som t.ex. Youtube, KB. (Som i annat fall sj�lva m�ste implementera denna logik). Antagandet �r att det enklast hanteras vid export j�mf�rt med �n att sprida logik  f�r grupperingen till respektive mottagande system.

Logik f�r export fr�n EMP/CVCMS
===============================
 - Per definierad bildtyp: landsacpe, poster, cinemascope, logoHomeTeam, logoAwayTeam
 - F�r bilder av samma typ och samma prio (fr�n 1 stigande) skapa f�ljande gruppering (se exemple XML nedan)
   o default = bild utan spr�k eller med spr�ket �xx� (kan var null)
   o localizations = lista p� spr�kanpassade bilder (samma typ och samma prio). Finns flera bilder med samma prio och spr�k s� skickas de med som de �r.  (kan vara en tom lista)



XSD f�rslag
===========
https://github.com/TV4/video-metadata-api/blob/image-refactorisation/src/main/xsd/export/images-alt6.xsd

Exemple XML
===========
https://github.com/TV4/video-metadata-api/blob/image-refactorisation/src/main/xsd/export/images-alt6.xsd.xml

