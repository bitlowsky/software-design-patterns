# Шаблоны проектирования ПО
## 18-ИВТ-1
* Дёмин Дмитрий
* Карпычева Ангелина
* Пигасин Дмитрий

## Вариант 6
Реализуйте систему генерации шаблона html страницы по описанию:  

1. Состава разделов (header, section1, ... , section_n, footer)  
2. Структуры каждой секции (количество блоков div)  

Добавьте опциональную возможность  выделять определенный раздел, блок рамкой.  
Сгенерированный html код выводите в консоль. 

## Как использовать
1. Описываем структуру страницы во внешнем файле.
   * Сначала указывается имя секции, потом через пробел количество вложенных блоков.
   * Одна секция - одна строка

2. Запускаем программу
3. Выделяем нужные блоки рамкой (опционально)
4. Сохраняем полученый шаблон (опционально)

## Пример
1. Создаем файл [html.txt](html.txt):
   ```
    header 10
    section
    section 3
    footer 2
    ```
2.  Запускаем программу.  
    Вывод:
    ```html
    <header>
        <div>div_0</div>
        <div>div_1</div>
        <div>div_2</div>
        <div>div_3</div>
        <div>div_4</div>
        <div>div_5</div>
        <div>div_6</div>
        <div>div_7</div>
        <div>div_8</div>
        <div>div_9</div>
    </header>

    <section>
    </section>

    <section>
            <div>div_0</div>
            <div>div_1</div>
            <div>div_2</div>
    </section>

    <footer>
            <div>div_0</div>
            <div>div_1</div>
    </footer>


    1.Add section border
    2.Add tag border
    3.Exit
    >>>
    ```