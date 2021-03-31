# Library
Clase :Library,Book,Person,Librarian,Reader,Account,AccountStatus,Author ,BookLocation,Sections

Librarian-> mosteneste clasa Person 
         -> implementeaza interfata ModifyData
         -> contine metodele : -> addBook 
                               -> deleteBook
                               -> enterInfo, bibliotecarul poate introduce informatii suplimetare  despre carti,care nu sunt neaparat importante pentru cititori
                               
Reader ->mosteneste clasa Person
       ->implementeaza interfata Search
       -> contine metodele : -> searchByTitle primeste doi parametrii 
                             -> searchByAuthor primeste doi parametrii 
                             -> createAccount
 
 Account -> contine metodele :-> equals
                              -> hashCode 
 Author -> mosteneste clasa Person
 Library -> are ArrayList de persoane( cititori, bibliotecari, autori) 
 Main contine -> 8 obiecte de tip Book 
              -> 3 Obiecte de tip Author
              -> un obiect de tip Library
              -> mai multe ArayLists care contin obiecte de tip Reader, Account, Sections, Books
              -> 2 obiecte de tip HashMap 
              -> bibliotecarul adauga carti,le sterge sau adauga informatii in lista bibliotecii cu ajutorul metodelor addBook,enterInfo,deleteBook
