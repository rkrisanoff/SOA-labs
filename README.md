# SOA Labs

## Lab 1

Swagger спецификацию для лабораторной работы №1 можно посмотреть [тут](https://se.ifmo.ru/~s284712/SOA/)

### Развертывание из репозитория

Необходимо скопировать на `helios` в `public_html` содержимое директории [lab1/public_html/SOA](./lab1/public_html/SOA)

```bash
scp -P 2222 -r ./public_html/SOA s284712@helios.cs.ifmo.ru:~/public_html
```

<!-- ### Развертывание с нуля статического сваггера

Клонируешь swagger-ui

```bash
git clone https://github.com/swagger-api/swagger-ui
```

В директории `dist` в `index.html` размещаете следующий скрипт:

```html
<script>
    window.onload = () => {
      window.ui = SwaggerUIBundle({
        urls: [
          {url: './spec/study-groups-app.yaml', name: 'studyGroupsApp'},
          {url: './spec/isu-app.yaml', name: 'isuApp'}
        ],
        dom_id: '#swagger-ui',
        presets: [
          SwaggerUIBundle.presets.apis,
          SwaggerUIStandalonePreset
        ],
        layout: "StandaloneLayout",
      });
    };
  </script>
```

Где в `urls` указываете пути к собственными спецификациям

Затем клонируете директорию в `public_html` -->