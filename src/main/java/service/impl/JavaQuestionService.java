package service.impl;



import model.Question;
import repository.QuestionRepository;
import service.QuestionService;

import java.util.List;



public class JavaQuestionService implements QuestionService {
    private final QuestionRepository repository;

    public JavaQuestionService(QuestionRepository repository) {
        this.repository = repository;
        initializeWithSampleQuestions();
    }

    private void initializeWithSampleQuestions() {
        repository.addQuestion(new Question("Что такое полиморфизм?", "Способность объекта реагировать на одно и то же сообщение по-разному."));
        repository.addQuestion(new Question("Какой тип цикла гарантированно исполнится хотя бы один раз?", "do-while"));
        repository.addQuestion(new Question("Назовите ключевое слово для создания анонимного внутреннего класса.", "new"));
        repository.addQuestion(new Question("Что такое instanceof?", "Оператор для проверки принадлежности объекта классу или интерфейсу."));
        repository.addQuestion(new Question("Что такое наследование?", "Механизм повторного использования кода путем создания новых классов на основе существующих."));
        repository.addQuestion(new Question("Какие модификаторы доступа существуют в Java?", "public, private, protected, default (package)."));
        repository.addQuestion(new Question("Что означает аббревиатура JVM?", "Java Virtual Machine — виртуальная машина Java."));
        repository.addQuestion(new Question("Какой метод запускается автоматически при создании объекта?", "Конструктор."));
        repository.addQuestion(new Question("Что такое статический импорт?", "Возможность прямого обращения к статическим членам класса без указания имени класса."));
        repository.addQuestion(new Question("Для чего используется интерфейс Comparable?", "Интерфейсы позволяют сравнивать объекты между собой."));
        repository.addQuestion(new Question("Как называется класс, содержащий только абстрактные методы?", "Интерфейс."));
        repository.addQuestion(new Question("Какой оператор используется для объединения условий в выражениях if?", "&& (логическое 'И'), || (логическое 'ИЛИ')."));
        repository.addQuestion(new Question("Что такое блок finally в try-catch конструкции?", "Блок, который выполняется независимо от возникновения исключения."));
        repository.addQuestion(new Question("Какой пакет содержит стандартные классы коллекций?", "java.util."));
        repository.addQuestion(new Question("Что такое рефлексия в Java?", "Процесс изучения структуры классов и объектов во время исполнения программы."));
        repository.addQuestion(new Question("Какой объект представляет поток выполнения в Java?", "Thread."));
        repository.addQuestion(new Question("Какой механизм позволяет синхронизировать доступ к ресурсам?", "Synchronized блоки и методы."));
        repository.addQuestion(new Question("Какой аннотацией помечаются устаревшие элементы API?", "@Deprecated."));
        repository.addQuestion(new Question("Какой метод вызывает сборщик мусора?", "finalize()."));
        repository.addQuestion(new Question("Что такое сериализация?", "Преобразование объекта в последовательность байтов для хранения или передачи."));
        repository.addQuestion(new Question("Какой класс является родителем всех исключений?", "Throwable."));
        repository.addQuestion(new Question("Что такое final переменная?", "Переменная, значение которой нельзя изменить после инициализации."));
        repository.addQuestion(new Question("Какой класс используется для создания многопоточных приложений?", "ExecutorService."));
        repository.addQuestion(new Question("Что такое lambda-выражение?", "Короткий способ объявления функционального интерфейса."));
        repository.addQuestion(new Question("Какой метод возвращает имя текущего потока?", "Thread.currentThread().getName()"));
        repository.addQuestion(new Question("Что такое автоподстановка типов (type inference)?", "Автоматическое определение типа переменной компилятором."));
        repository.addQuestion(new Question("Какой тип коллекции гарантирует порядок вставки элементов?", "LinkedList, ArrayList."));
        repository.addQuestion(new Question("Какой метод возвращает размер массива?", "length."));
        repository.addQuestion(new Question("Какой класс реализует очередь с приоритетами?", "PriorityQueue."));
        repository.addQuestion(new Question("Какой метод возвращает хэш-код объекта?", "hashCode()."));
        repository.addQuestion(new Question("Какой класс предназначен для безопасного параллельного изменения списка?", "CopyOnWriteArrayList."));
        repository.addQuestion(new Question("Какой класс обеспечивает потокобезопасный словарь?", "ConcurrentHashMap."));
        repository.addQuestion(new Question("Какой метод создает экземпляр объекта по типу?", "Class.newInstance()."));
        repository.addQuestion(new Question("Какой метод удаляет элемент из множества?", "remove()."));
        repository.addQuestion(new Question("Какой класс хранит данные в виде пар ключ-значение?", "Map."));
        repository.addQuestion(new Question("Какой класс реализован для безопасной блокировки ресурсов?", "ReentrantLock."));
    }

    @Override
    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    @Override
    public void addQuestion(Question question) {
        repository.addQuestion(question);
    }

    @Override
    public void removeQuestion(Question question) {
        repository.removeQuestion(question);
    }
}