import os
import subprocess
from datetime import datetime, timedelta
import random

# -------- CONFIG --------
repo_path = "https://github.com/subrata-code/study-java-0-to-master.git"  # Replace with your local repo path
branch = "main"
start_date = datetime(2025, 5, 1)  # 1st May
end_date = datetime.now()  # today
java_folder = os.path.join(repo_path, "daily_java_files")
os.makedirs(java_folder, exist_ok=True)

# Java code templates
java_templates = [
    """public class {name} {{
    public static void main(String[] args){{
        System.out.println("Fibonacci of 10 is: " + fibonacci(10));
    }}
    static int fibonacci(int n){{
        if(n<=1) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }}
}}""",
    """public class {name} {{
    public static void main(String[] args){{
        int[] arr = {{5,3,8,1,2}};
        bubbleSort(arr);
        for(int a:arr) System.out.print(a+" ");
    }}
    static void bubbleSort(int[] arr){{
        int n = arr.length;
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-i-1;j++)
                if(arr[j]>arr[j+1]){{
                    int temp=arr[j]; arr[j]=arr[j+1]; arr[j+1]=temp;
                }}
    }}
}}""",
    """public class {name} {{
    public static void main(String[] args){{
        System.out.println("Factorial of 5 is: " + factorial(5));
    }}
    static int factorial(int n){{
        if(n<=1) return 1;
        return n*factorial(n-1);
    }}
}}""",
    """public class {name} {{
    public static void main(String[] args){{
        String str="GitHubDaily";
        System.out.println("Reversed string: "+new StringBuilder(str).reverse());
    }}
}}"""
]

# Commit messages
commit_messages = [
    "Add array examples",
    "Implement linked list",
    "Add binary search",
    "Implement stack",
    "Add queue example",
    "Implement bubble sort",
    "Add fibonacci function",
    "Add factorial function",
    "Add string reverse",
    "Implement simple class",
    "Add Java utility methods",
    "Refactor code structure"
]

# Commit cycle pattern: skip 1,2,3,5 days
commit_cycle = [1, 1, 2, 3, 5]

# -------- MAIN --------
current_date = start_date
cycle_index = 0

while current_date <= end_date:
    # Generate Java file
    class_name = f"DailyCode_{current_date.strftime('%Y%m%d')}"
    java_code = random.choice(java_templates).format(name=class_name)
    file_path = os.path.join(java_folder, f"{class_name}.java")
    with open(file_path, "w") as f:
        f.write(java_code)

    # Git add, commit with date
    subprocess.run(["git", "-C", repo_path, "add", "."], check=True)
    commit_message = random.choice(commit_messages)
    commit_date_str = current_date.strftime("%Y-%m-%dT12:00:00")  # set noon
    subprocess.run(["git", "-C", repo_path, "commit", "--date", commit_date_str, "-m", commit_message], check=True)

    # Move to next commit date based on cycle
    skip_days = commit_cycle[cycle_index % len(commit_cycle)]
    current_date += timedelta(days=skip_days)
    cycle_index += 1

# -------- PUSH --------
subprocess.run(["git", "-C", repo_path, "push", branch], check=True)

print("All commits generated and pushed successfully!")
