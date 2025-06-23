
from django.db import models
from django.core.validators import RegexValidator # Import the RegexValidator class from django.core.validators

class User(models.Model):
    username = models.CharField(max_length=100,      #set the maximum length of the username to 100 characters
    validators=[RegexValidator(r'^[a-zA-Z0-9]*$',    # Use the RegexValidator to ensure that the username is alphanumeric
    message='Username must be alphanumeric', 
    code="invalid_username"),],
    unique=True)  # User's unique username  
    email = models.EmailField(unique=True)  # User's unique email
    created_at = models.DateTimeField(auto_now_add=True)  # Timestamp when the user was created


    def __str__(self):
        return self.username

class Post(models.Model):
    content = models.TextField()  # The text content of the post
    author = models.ForeignKey(User, on_delete=models.CASCADE)  # The user who created the post
    created_at = models.DateTimeField(auto_now_add=True)  # Timestamp when the post was created


    def __str__(self):
        return self.content[:50]

class Comment(models.Model):
    text = models.TextField()
    author = models.ForeignKey(User, related_name='comments', on_delete=models.CASCADE)
    post = models.ForeignKey(Post, related_name='comments', on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)


    def __str__(self):
        return f"Comment by {self.author.username} on Post {self.post.id}"


