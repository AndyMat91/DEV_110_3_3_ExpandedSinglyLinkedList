package org.example;

import java.util.List;

public class ExpandedLinkedList {

    private Node head;  //голова

    public ExpandedLinkedList() {
    }

    public ExpandedLinkedList(Node head) {
        this.head = head;
    }

    private static class Node {
        public String[] data; //данные
        public Node next; //ссылка на следующий узел

        public Node(String data) {
            this.data = new String[10];
            this.data[0] = data;
        }

        public Node() {
            this.data = new String[10];
        }
    }

    public void addInEnd(String data) {
        if (data != null) {
            if (head == null) {
                Node newNode = new Node(data);
                head = newNode;
            } else {
                Node currentNode = head;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                for (int i = 0; i < currentNode.data.length; i++) {
                    if (currentNode.data[i] == null) {
                        currentNode.data[i] = data;
                        break;
                    } else if (i == 9 && currentNode.data[i] != null) {
                        Node newNode = new Node(data);
                        currentNode.next = newNode;
                        break;
                    }
                }
            }
        }
    }

    public void addInBeginning(String data) {
        if (data != null) {
            Node newNode = new Node(data);
            if (head != null) {
                int z = 0;
                for (int i = 0; i < head.data.length; i++) {       //проверяем, есть ли место в голове
                    if (head.data[i] == null) {
                        z = 1;
                        break;
                    }
                }
                if (z == 1) {                                    // если есть, то копирум  данные с головы
                    for (int x = 0; x < head.data.length - 1; x++) {
                        newNode.data[x + 1] = head.data[x];
                    }
                    newNode.next = head.next;
                } else {
                    newNode.next = head;
                }
            }
            head = newNode;
        }
    }

    public void printAll() {
        Node currentNode = head;
        while (currentNode != null) {
            for (int i = 0; i < currentNode.data.length; i++) {
                if (currentNode.data[i] != null)
                    System.out.println(currentNode.data[i]);
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void printAllWithNull() {
        Node currentNode = head;
        while (currentNode != null) {
            for (int i = 0; i < currentNode.data.length; i++) {
                    System.out.println(currentNode.data[i]);
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public String extValueFromTheBeginningWithoutDeleting() {  //извлечение значения из начала списка без его удаления из списка;
        return head.data[0];
    }

    public String extValueFromTheBeginningWithDeleting() {  //извлечение значения из начала списка с удалением его из списка;
        String x = null;
        for (int i = 0; i < head.data.length; i++) {
            if (head.data[i] != null) {
                x = head.data[i];
                remove(head.data[i]);
                break;
            }
        }
        return x;
    }

    public String extValueFromTheEndWithoutDeleting() {  //извлечение значения из конца списка без удаления из списка;
        Node currentNode = head;
        String x = null;
        if (head == null)
            return null;
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            for (int i = currentNode.data.length - 1; i >= 0; i--) {
                if (currentNode.data[i] != null) {
                    x = currentNode.data[i];
                    break;
                }
            }
        }
        return x;
    }

    public String extValueFromTheEndWithDeleting() { //извлечение значения из конца списка с удалением;
        Node currentNode = head;
        String x = null;
        if (head == null)
            return null;
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            for (int i = currentNode.data.length - 1; i >= 0; i--) {
                if (currentNode.data[i] != null) {
                    x = currentNode.data[i];
                    remove(x);
                    break;
                }
            }
        }
        return x;
    }

    public boolean empty() {   //определение, является ли список пустым, или нет (не по голове а по наличию значений в списке);
        Node currentNode = head;
        while (currentNode != null) {
            for (int i = 0; i < currentNode.data.length; i++) {
                if (currentNode.data[i] != null) {
                    return false;
                }
            }
            if (currentNode.next != null) {
                currentNode = currentNode.next;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean searchValue(String data) {   //определение, содержит ли список заданное значение, или нет;
        if (data != null) {
            Node currentNode = head;
            while (currentNode != null) {
                for (int i = 0; i < currentNode.data.length; i++) {
                    if (data.equals(currentNode.data[i])) {
                        return true;
                    }
                }
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void remove(String data) {//удаление заданного значения из списка;
        if (head == null || data == null) return;
        Node currentNode = head;
        if (searchValue(data)) {
            while (currentNode != null) {
                for (int i = 0; i < currentNode.data.length; i++) {
                    if (currentNode.data[i] != null) {
                        if (currentNode.data[i].equals(data)) {
                            currentNode.data[i] = null;
                            break;
                        }
                    }
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void addAllArrayValuesToTheBeginning(String... x) {
        for (int i = x.length - 1; i >= 0; i--) {
            addInBeginning(x[i]);
        }
    }

    public void addAllCollectionValuesToTheBeginning(List<String> x) {
        for (int i = x.size() - 1; i >= 0; i--) {
            addInBeginning(x.get(i));
        }
    }

    public void addAllArrayValuesToTheEnd(String... x) {
        for (String o : x) {
            addInEnd(o);
        }
    }

    public void addAllCollectionValuesToTheEnd(List<String> x) {
        for (String i : x) {
            addInEnd(i);
        }
    }

    public void absorbingTheListToTheTop(ExpandedLinkedList x) {
        if (x.head == null) return;
        Node currentNodeX = x.head;
        String[] help = new String[100];
        int a = 0;
        while (currentNodeX != null) {
            for (int i = 0; i < currentNodeX.data.length; i++) {
                if (currentNodeX.data[i] != null) {
                    help[a] = currentNodeX.data[i];
                    a++;
                }
            }
            currentNodeX = currentNodeX.next;
        }
        for (int s = help.length - 1; s >= 0; s--) {
            if (help[s] != null) {
                addInBeginning(help[s]);
                x.remove(help[s]);
            }
        }
    }


    public void absorbingTheListToTheEnd(ExpandedLinkedList x) {
        if (x.head == null) return;
        Node currentNodeX = x.head;
        while (currentNodeX != null) {
            for (int i = 0; i < currentNodeX.data.length; i++) {
                if (currentNodeX.data[i] != null) {
                    addInEnd(currentNodeX.data[i]);
                    x.remove(currentNodeX.data[i]);
                }
            }
            currentNodeX = currentNodeX.next;

        }
    }

    public void compression() {   //сжатие списка;
        Node currentNodePrevious = null;
        Node currentNode = head;
        Node currentNodeNext = head.next;

        while (currentNode.next != null) {
            for (int i = 0; i < currentNode.data.length; i++) {
                if (currentNode.data[i] != null) {
                    break;
                } else if (currentNode.data[9] == null) {
                    if (currentNode == head) head = currentNodeNext;
                } else {
                    currentNodePrevious.next = currentNodeNext;
                }
            }
            currentNodePrevious = currentNode;
            currentNode = currentNode.next;
            currentNodeNext = currentNode.next;
        }
    }
}