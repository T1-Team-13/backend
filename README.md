# Spring Boot + PostgreSQL (Docker)

## Запуск проекта

### 1. Клонирование репозитория
```bash
git clone https://github.com/T1-Team-13/backend
```

### 2. Запуск сервисов
```bash
docker compose up
```

### 3. Войти в контейнер с PostgreSQL
```bash
docker exec -it postgres bash
```

### 4. Запустить клиент psql
```bash
psql -U postgres -d t1case3
```

### 5. Скопировать содержимое файла data.sql (находится в папке /sql), вставить в терминал, нажать Enter

## Выход из контейнера

### 1. Выйти из psql
```bash
\q
```

### 2. Выйти из контейнера
```bash
exit
```

### 3. Закрыть контейнер
```bash
docker compose down
```