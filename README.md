Консольний месенджер - Серверна частина.  

Посилання на клієнтську частину - https://github.com/simakarenko/ChatClientMY.git

Можливості коду:

- автореєстрація користувача;

1 user:

Enter your login:   
svitlana  
Enter your password:   
1234

2 user:

Enter your login:   
vasya  
Enter your password:   
2222

- перегляд списку користувачів online;

List of friends online: Yes - y, No - n.  
y  
svitlana

- перевірка статусу(online/ofline) будь-якого користувача за login;
  
Check user status: Yes - y, No - n.  
y  
Enter user name:   
svitlana  
svitlana - online

- відправка приватних повідомлень;

Send a private message: Yes - y, No - n.  
y  
Enter the recipient's login:  
vasya  
Enter your message:   
[Thu Jan 11 11:38:13 EET 2024, From: svitlana, crName: , To: svitlana] aaaaaaaaaa  
[Thu Jan 11 11:45:06 EET 2024, From: vasya, crName: , To: svitlana] Hello

- обмін повідомленнями в окремих чат-кімнатах;

Open chat-room: Yes - y, No - n.  
y  
Enter the name of the chat-room: AAA, BBB, CCC, DDD.  
AAA  
Enter your message:   
[Thu Jan 11 11:47:32 EET 2024, From: svitlana, crName: AAA, To: ] Chat  
Hi  
[Thu Jan 11 11:48:19 EET 2024, From: vasya, crName: AAA, To: ] Hi

- спільний чат з усіма користувачами месенджера;

Enter your message:   
[Thu Jan 11 11:51:01 EET 2024, From: vasya, crName: , To: ] Hello  
[Thu Jan 11 11:51:34 EET 2024, From: svitlana, crName: , To: ] Hi  
World  
[Thu Jan 11 11:52:26 EET 2024, From: aaaa, crName: , To: ] World
