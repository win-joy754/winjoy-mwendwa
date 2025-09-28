#include <stdio.h>
#include <stdlib.h>
#define SIZE 5
typedef struct {
    int items[SIZE];
    int front;
    int rear;
} CircularQueue;
void initialize(CircularQueue *q);
int isFull(CircularQueue *q);
int isEmpty(CircularQueue *q);
void enqueue(CircularQueue *q, int value);
int dequeue(CircularQueue *q);
int peek(CircularQueue *q);
void display(CircularQueue *q);

int main() {
    CircularQueue q;
    initialize(&q);

    int choice, value;

    while (1) {
        printf("\nCircular Queue Menu:\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Peek\n");
        printf("4. Display\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to enqueue: ");
                scanf("%d", &value);
                enqueue(&q, value);
                break;
            case 2:
                dequeue(&q);
                break;
            case 3:
                value = peek(&q);
                if (value != -1)
                    printf("Front element: %d\n", value);
                break;
            case 4:
                display(&q);
                break;
            case 5:
                printf("Exiting program.\n");
                exit(0);
            default:
                printf("Invalid choice. Try again.\n");
        }
    }

    return 0;
}
void initialize(CircularQueue *q) {
    q->front = -1;
    q->rear = -1;
}
int isFull(CircularQueue *q) {
    return ((q->rear + 1) % SIZE == q->front);
}
int isEmpty(CircularQueue *q) {
    return (q->front == -1);
}
void enqueue(CircularQueue *q, int value) {
    if (isFull(q)) {
        printf("Queue is full! Cannot enqueue %d\n", value);
        return;
    }

    if (isEmpty(q)) {
        q->front = 0;
    }

    q->rear = (q->rear + 1) % SIZE;
    q->items[q->rear] = value;
    printf("Enqueued %d\n", value);
}
int dequeue(CircularQueue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty! Cannot dequeue\n");
        return -1;
    }

    int value = q->items[q->front];

    if (q->front == q->rear) {
        q->front = -1;
        q->rear = -1;
    } else {
        q->front = (q->front + 1) % SIZE;
    }

    printf("Dequeued %d\n", value);
    return value;
}
int peek(CircularQueue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty! Nothing to peek\n");
        return -1;
    }

    return q->items[q->front];
}
void display(CircularQueue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty!\n");
        return;
    }

    printf("Queue contents: ");
    int i = q->front;
    while (1) {
        printf("%d ", q->items[i]);
        if (i == q->rear)
            break;
        i = (i + 1) % SIZE;
    }
    printf("\n");
}