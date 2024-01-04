traduccion(juan, juan).
traduccion(jose, jose).
traduccion( "JOSÉ", "JOSÉ").
traduccion(maria, maria).
traduccion("MARÍA", "MARÍA").
traduccion(lee, read).
traduccion(prefiere, prefers).
traduccion(periodico,newspaper).
traduccion(novela,novel).
traduccion(zumo,juice).
traduccion(rocodromo,rockodrome).
traduccion(vecino,neighbor).
traduccion(agil,agile).
traduccion(ayer,yesterday).
traduccion(paella,paella).
traduccion(bebe, drink).
traduccion(escala, scale).
traduccion(filosofia,philosophy).
traduccion(ama, loves).
traduccion(come, eats).
traduccion(aunque, although).
traduccion(comen, eat).
traduccion(derecho, law).
traduccion(estudia, studies).
traduccion(hace, does).
traduccion(canta, sings).
traduccion(alzo, raised).
traduccion(esta, "is").
traduccion(es, "is").
traduccion(era, was).
traduccion(habla, speaks).
traduccion(depende, depends).
traduccion(vimos, saw).
traduccion(recoge, collects).
traduccion(toma, takes).
traduccion(compre, bought).
traduccion(beben, drink).
traduccion(salta, jumps).
traduccion(sonrie, smiles).
traduccion(sirve, serves).
traduccion(cazo, dipper).
traduccion(hombre, man).
traduccion(mujer, woman).
traduccion(gato, cat).
traduccion(raton, mouse).
traduccion(ratones, mice).
traduccion(alumno, student).
traduccion(alumna, student).
traduccion(manzana, apple).
traduccion(manzanas, apples).
traduccion(patatas, potatoes).
traduccion(tenedor, fork).
traduccion(cuchillo, knife).
traduccion(el, the).
traduccion(ella, she).
traduccion(practica, practice).
traduccion(canario, canary).
traduccion(paloma, dove).
traduccion(vuelo, flight).
traduccion(madrid, madrid).
traduccion(reflejos, reflexes).
traduccion(esperanza, hope).
traduccion(vida, life).
traduccion(nino, nino).
traduccion(lugar, place).
traduccion(universidad, university).
traduccion(nacimiento, birth).
traduccion(profesor, teacher).
traduccion(mesa, table).
traduccion(cafe, coffee).
traduccion(pantalon, pants).
traduccion(corbata, tie).
traduccion(hector, hector).
traduccion(cerveza, beer).
traduccion(irene, irene).
traduccion(procesador, processor).
traduccion(textos, texts).
traduccion(herramienta, tool).
traduccion(documentos, documents).
traduccion(escribir, write).
traduccion(el, the).
traduccion(la, the).
traduccion(los, the).
traduccion(las, the).
traduccion(un, a).
traduccion(una, a).
traduccion(unos, some).
traduccion(unas, some).
traduccion(mi, my).
traduccion(tu, your).
traduccion(su, his).
traduccion(nuestro, our).
traduccion(nuestra, our).
traduccion(vuestro, your).
traduccion(vuestra, your).
traduccion(grande, big).
traduccion(roja, red).
traduccion(rojas, red).
traduccion(negro, black).
traduccion(negros, blacks).
traduccion(blanca, white).
traduccion(moreno, moreno).
traduccion(morena, morena).
traduccion(alta, tall).
traduccion(alto, tall).
traduccion(delicado, carefull).
traduccion(fritas, delicate).
traduccion(alegre, happy).
traduccion(potente, powerful).
traduccion(gris, gray).
traduccion(a, a).
traduccion(ante, before).
traduccion(bajo, under).
traduccion(cabe, "it is worth").
traduccion(con, whith).
traduccion(contra, against).
traduccion(de, from).
traduccion(desde, from).
traduccion(en, in).
traduccion(entre, between).
traduccion(hacia, to).
traduccion(hasta, until).
traduccion(para, to).
traduccion(por, by).
traduccion(segun, "according to").
traduccion(sin, without).
traduccion(so, so).
traduccion(sobre, about).
traduccion(tras, after).
traduccion(durante, while).
traduccion(mediante, via).
traduccion(y, and).
traduccion(que, that).
traduccion(e, and).
traduccion(o, or).
traduccion(u, or).
traduccion(muy, very).
traduccion(claramente, clearly).
traduccion(lejos, far).
traduccion(mucho, much).
traduccion(lento, slow).
traduccion(solamente, only).
traduccion(bastante, quite).
traduccion(",", ",").
traduccion(',', ',').
traduccion(y, and).
traduccion(pero, but).
traduccion(que, that).
traduccion(mientras, while).
traduccion(pablo, pablo).
traduccion(vive, live).
traduccion(afueras, outskirts).
traduccion(rapido, fast).
traduccion(mosqueteros, musketeers).
traduccion(blandieron, brandished).
traduccion(espadas, swords).
traduccion(sara, sara).
traduccion(sabado, saturday).
traduccion(coches, cars).
traduccion(carreras, races).
traduccion(rapidos, fast).
traduccion(son, are).
traduccion(toca, plays).
traduccion(guitarra, guitar).
traduccion(tardes, afternoons).


en_ingles(X):-
    traduccion(X, Y),
    write(Y).

traductor([]):-nl.
traductor([X]) :- en_ingles(X).
traductor([X|Xs]) :- en_ingles(X), write(" "), traductor(Xs).
