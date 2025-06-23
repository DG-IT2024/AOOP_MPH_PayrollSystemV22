import bcrypt
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from .models import User, Post, Comment
from .serializers import UserSerializer, PostSerializer, CommentSerializer
from django.contrib.auth.models import User
from django.contrib.auth import authenticate
from django.contrib.auth.models import Group, User
from rest_framework.permissions import IsAuthenticated
from .permissions import IsTaskAssignee
from rest_framework.authentication import TokenAuthentication
from rest_framework.permissions import IsAuthenticated



# Create a new user with a hashed password
user = User.objects.create_user(username="new_user", password="secure_pass123")
print(user.password)  # Outputs a hashed password

# Authenticate the user
user = authenticate(username="new_user", password="secure_pass123")
if user is not None:
    print("Authentication successful!")
else:
    print("Invalid credentials.")

# Create a new group and assign a user
admin_group = Group.objects.create(name="Admin")
user = User.objects.get(username="admin_user")
user.groups.add(admin_group)


# future work
# class TaskDetailView(APIView):
#     permission_classes = [IsAuthenticated, IsTaskAssignee]


#     def get(self, request, pk):
#         task = Task.objects.get(pk=pk)
#         self.check_object_permissions(request, task)
#         return Response({"title": task.title, "description": task.description})


class SecureView(APIView):
    authentication_classes = [TokenAuthentication]
    permission_classes = [IsAuthenticated]


    def get(self, request):
        return Response({"message": "Secure endpoint accessed!"})


class UserListCreate(APIView):
    def get(self, request):
        users = User.objects.all()
        serializer = UserSerializer(users, many=True)
        return Response(serializer.data)


    def post(self, request):
        serializer = UserSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class PostListCreate(APIView):
    def get(self, request):
        posts = Post.objects.all()
        serializer = PostSerializer(posts, many=True)
        return Response(serializer.data)


    def post(self, request):
        serializer = PostSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class CommentListCreate(APIView):
    def get(self, request):
        comments = Comment.objects.all()
        serializer = CommentSerializer(comments, many=True)
        return Response(serializer.data)


    def post(self, request):
        serializer = CommentSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

# import json
# from django.http import JsonResponse
# from django.views.decorators.csrf import csrf_exempt
# from .models import User
# from .models import Post

# # for Users 
# def get_users(request):
#     try:
#         users = list(User.objects.values('id', 'username', 'email', 'created_at'))
#         return JsonResponse(users, safe=False)
#     except Exception as e:
#         return JsonResponse({'error': str(e)}, status=500)


# @csrf_exempt
# def create_user(request):
#     if request.method == 'POST':
#         try:
#             data = json.loads(request.body)
#             user = User.objects.create(username=data['username'], email=data['email'])
#             return JsonResponse({'id': user.id, 'message': 'User created successfully'}, status=201)
#         except Exception as e:
#             return JsonResponse({'error': str(e)}, status=400)

# @csrf_exempt
# def update_user(request, id):
#     if request.method == 'PUT':
#         try:
#             data = json.loads(request.body)
#             email = data['email']
#             user = User.objects.filter(id=id).first()
#             # data = UserSerializer(isinstance=user, data=request.data)
#             user.email = email
#             user.save()
#             return JsonResponse({'message': 'User updated successfully'}, status=201)
#         except Exception as e:
#             return JsonResponse({'error': str(e)}, status=400)


# @csrf_exempt
# def delete_user(request, id):
#     if request.method == 'DELETE':
#         try:
#             user = User.objects.filter(id=id).first()
#             user.delete()
#             #User.objects.delete(id=id)
#             return JsonResponse({'message': 'User deleted successfully'}, status=200)
#         except Exception as e:
#             return JsonResponse({'error': str(e)}, status=400)

# # for Posts 
# def get_posts(request):
#     try:
#         posts = list(Post.objects.values('id', 'content', 'author', 'created_at'))
#         return JsonResponse(posts, safe=False)
#     except Exception as e:
#         return JsonResponse({'error': str(e)}, status=500)

# @csrf_exempt
# def create_post(request):
#     if request.method == 'POST':
#         try:
#             data = json.loads(request.body)
#             author = User.objects.get(id=data['author'])
#             post = Post.objects.create(content=data['content'], author=author)
#             return JsonResponse({'id': post.id, 'message': 'Post created successfully'}, status=201)
#         except User.DoesNotExist:
#             return JsonResponse({'error': 'Author not found'}, status=404)
#         except Exception as e:
#             return JsonResponse({'error': str(e)}, status=400)




