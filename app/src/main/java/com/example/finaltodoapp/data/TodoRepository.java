//package com.example.finaltodoapp.data;
//
//import android.app.Application;
//import android.os.AsyncTask;
//
//import com.example.finaltodoapp.model.ETodo;
//import com.example.finaltodoapp.model.ToDoDAO;
//
//public class TodoRepository {
//    private ToDoDAO mTodoDAO;
//    public TodoRepository(Application application){
//        TodoRoomDatabase database = TodoRoomDatabase.getDatabase(application);
//        mTodoDAO = database.mTodoDAO();
//    }
//
//    public ToDoDAO getmTodoDAO() {
//        return mTodoDAO;
//    }
//
//    public void setmTodoDAO(ToDoDAO mTodoDAO) {
//        this.mTodoDAO = mTodoDAO;
//    }
//
//    private static class insertTodoAsyncTask extends AsyncTask<ETodo,Void,Void> {
//        private ToDoDAO mTodoDao;
//        private insertTodoAsyncTask(ToDoDAO todoDAO){
//            mTodoDao = todoDAO;
//        }
//
//        @Override
//        protected Void doInBackground(ETodo... etTodos){ ///... signifies the collection
//            mTodoDao.insert(etTodos[0]);
//            return null;
//        }
//
//        public void insert(ETodo eTodo){
//            new insertTodoAsyncTask(mTodoDao).execute(eTodo);
//        }
//
//    }
//
//}
