# Scheduled Notification System 📬

Sistema de envio de notificações agendadas com suporte a múltiplos canais (E-mail, Push, WhatsApp,Sms), usando arquitetura com Strategy Pattern e Spring Boot.

## ✨ Funcionalidades

- Agendamento de notificações
- Envio por diferentes canais (extensível com Strategy)
- Verificação automática de notificações pendentes e com erro
- Persistência com JPA e MySQL

## 🛠️ Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Strategy Pattern
- Scheduled Tasks

## 🚀 Como executar

1. Clone o repositório:
2. Configure o `application.yml` com seu banco de dados
3. Execute.

🔗 Endpoints da API
📌 Criar nova notificação
POST /notifications

json:
{
  "dateTime": "",
  "destination": "",
  "message": "",
  "channel": ""
}
🔁 Substitua o campo "channel" para "EMAIL", "SMS", ou "WHATSAPP" conforme o canal desejado.
    exemplo de dateTime:2025-07-20T15:42:00.

📌 Consultar notificação por ID
GET /notifications/{id}
Exemplo:

GET http://localhost:8081/notifications/1
🗑️ Cancelar notificação
DELETE /notifications/{id}

Exemplo:

DELETE http://localhost:8081/notifications/1

📄 Observações

Esta aplicação realiza o envio no prazo estimado porém nao está implementada nenhuma forma de envio para as diversas plataformas.

O envio ocorre automaticamente quando a data/hora da notificação chega.

Cada canal de envio é implementado como uma estratégia independente, facilitando adição de novos canais.
