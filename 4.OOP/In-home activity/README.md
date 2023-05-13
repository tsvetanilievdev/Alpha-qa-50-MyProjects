# Defining Classes Practice

It's time to practice the building blocks of a class:

- fields - to store data
- constructors - to create classes more easily and to make sure our classes have correct data
- methods - to do something with the stored data

## 1. Fields

Create a class - `ForumPost`. Define several fields inside that class:

- `author` (String)
- `text` (String)
- `upVotes` (int)

### Test your code

If everything is done correctly, pasting the following code inside your `Main` method should **compile** and: **produce correct output**.

#### Code

```java
ForumPost post1 = new ForumPost();
post1.author = "Steven";
post1.text = "How to find use for every Microsoft product.";
post1.upVotes = 2;

ForumPost post2 = new ForumPost();
post2.author = "Edward";
post2.text = "Ford Focus for sale. First owner. Good mileage.";
post2.upVotes = 300;

System.out.printf("%s / by %s, %d votes. %n", post1.text, post1.author, post1.upVotes);
System.out.printf("%s / by %s, %d votes. %n", post2.text, post2.author, post2.upVotes);
```

#### Expected output

```none
How to find use for every Microsoft product. / by Steven, 2 votes.
Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.
```

## 2. Constructor

Refactor your class to have a constructor that accepts the `author`, `text` and `upvotes`.

### Test your code

After refactoring, the following code should compile and produce correct output:

#### Code

```java
ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.", 2);
ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

System.out.printf("%s / by %s, %d votes. %n", post1.text, post1.author, post1.upVotes);
System.out.printf("%s / by %s, %d votes. %n", post2.text, post2.author, post2.upVotes);
```

#### Expected output

```none
How to find use for every Microsoft product. / by Steven, 2 votes.
Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.
```

## 3. Optional parameters in the constructor

Is there a way to make passing `upVotes` optional? How about a second, **overloaded** constructor?

### Test your code

#### Code

```java
ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.");
ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

System.out.printf("%s / by %s, %d votes. %n", post1.text, post1.author, post1.upVotes);
System.out.printf("%s / by %s, %d votes. %n", post2.text, post2.author, post2.upVotes);

```

#### Expected output

```none
How to find use for every Microsoft product. / by Steven, 0 votes.
Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.
```

## 4. Methods

Add a method `format()` to `ForumPost`. We can do the formatting there and not rely on _outside_ code to correctly format a post.

### Test your code

#### Code

```java
ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.");
ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

System.out.print(post1.format());
System.out.print(post2.format());
```

#### Expected output

```none
How to find use for every Microsoft product. / by Steven, 0 votes.
Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.

```

## 5. Replies

Refactor your class to support a collection of replies:  
Fields:

- `replies` (ArrayList\<String\>)

Methods:

- refactor the `format()` method to display the replies or a message that there are no replies.

### Test your code

#### Code

```java
ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.");
post1.replies.add("I like Google!");
post1.replies.add("Ugh, Microsoft... :(");

ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

System.out.print(post1.format());

System.out.print(post2.format());
```

#### Expected output

```none
How to find use for every Microsoft product. / by Steven, 0 votes.
- I like Google!
- Ugh, Microsoft... :(

Ford Focus for sale. First owner. Good mileage. / by Edward, 300 votes.
```
