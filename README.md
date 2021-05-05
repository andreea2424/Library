# Library
Pentru a intra in "aplicatie" persoana, in cazul in care are cont, trebuie sa isi introduca username-ul si parola contului in caz contrar sa isi faca un cont. 

Dupa ce se autentifica persoana va putea sa aleage din lista de comenzi de mai jos. 

1 - Set the name of the library.
2 - Print all books in the file.
3 - Print ll authors in the file.
4 - Print all readers in the file.
5 - Print all accounts in the file.
6 - List of commands.
7 - Add a book to the library.
8 - Delete a book.
9 - Reserve a book before you borrow it.
10 - Extern the date of return of a book.
11 - Add an author in the database.
12 - Update your account.
13 - Search a book by a title.
14 - Search a book by author.

Utilizatorul - poate sa vada toate cartile, autorii, membrii si conturile prin comenzile 2, 3, 4, 5.
             - poate sa rezerve o carte , in cazul in care cartea este impumutata va aparea mesaj data la care cartea va putea sa fie rezervata din nou, iar in cazul in care nu e nici rezervata nici imprumutata rezervarea se poate face doar pentru 24h
             - poate sa extinda data de returnare a unei carti la data de return se vor adauga inca 14 zile doar daca acea carte nu a fost rezervata 
             - poate sa adauge si carti si autori 
             - poate sa caute carti sau autori 
Cu clasele singleton WritingCSV Si ReadingCSV(nu am reusit sa le fac generice), la inceputul programului sunt preluate datele si la final sunt adaugate inapoi cu modificarile facute in timpul programului.
accountsForReaders.csv
audit.csv
books.csv
bookLending.csv - datele care sunt modificate in urma metodelor extern the date of return si reserve a book
readers.csv
authors.csv
In clasa Methods este o metoda care adauga la finalul programului comenzile care au fost efectuate.

                                         
