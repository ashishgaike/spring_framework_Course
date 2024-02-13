package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(6);
        modelClasses.add(com.fitzafful.gliveportal.db.Notification.class);
        modelClasses.add(com.fitzafful.gliveportal.db.Bill.class);
        modelClasses.add(com.fitzafful.gliveportal.db.Student.class);
        modelClasses.add(com.fitzafful.gliveportal.db.Book.class);
        modelClasses.add(com.fitzafful.gliveportal.db.Grade.class);
        modelClasses.add(com.fitzafful.gliveportal.db.Course.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(6);
        infoMap.put(com.fitzafful.gliveportal.db.Notification.class, io.realm.NotificationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.fitzafful.gliveportal.db.Bill.class, io.realm.BillRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.fitzafful.gliveportal.db.Student.class, io.realm.StudentRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.fitzafful.gliveportal.db.Book.class, io.realm.BookRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.fitzafful.gliveportal.db.Grade.class, io.realm.GradeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.fitzafful.gliveportal.db.Course.class, io.realm.CourseRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            return io.realm.NotificationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            return io.realm.BillRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            return io.realm.StudentRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            return io.realm.BookRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            return io.realm.GradeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            return io.realm.CourseRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            return io.realm.NotificationRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            return io.realm.BillRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            return io.realm.StudentRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            return io.realm.BookRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            return io.realm.GradeRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            return io.realm.CourseRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            return io.realm.NotificationRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            return io.realm.BillRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            return io.realm.StudentRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            return io.realm.BookRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            return io.realm.GradeRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            return io.realm.CourseRealmProxy.getSimpleClassName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
                return clazz.cast(new io.realm.NotificationRealmProxy());
            }
            if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
                return clazz.cast(new io.realm.BillRealmProxy());
            }
            if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
                return clazz.cast(new io.realm.StudentRealmProxy());
            }
            if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
                return clazz.cast(new io.realm.BookRealmProxy());
            }
            if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
                return clazz.cast(new io.realm.GradeRealmProxy());
            }
            if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
                return clazz.cast(new io.realm.CourseRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.copyOrUpdate(realm, (com.fitzafful.gliveportal.db.Notification) obj, update, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            return clazz.cast(io.realm.BillRealmProxy.copyOrUpdate(realm, (com.fitzafful.gliveportal.db.Bill) obj, update, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            return clazz.cast(io.realm.StudentRealmProxy.copyOrUpdate(realm, (com.fitzafful.gliveportal.db.Student) obj, update, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            return clazz.cast(io.realm.BookRealmProxy.copyOrUpdate(realm, (com.fitzafful.gliveportal.db.Book) obj, update, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            return clazz.cast(io.realm.GradeRealmProxy.copyOrUpdate(realm, (com.fitzafful.gliveportal.db.Grade) obj, update, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            return clazz.cast(io.realm.CourseRealmProxy.copyOrUpdate(realm, (com.fitzafful.gliveportal.db.Course) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            io.realm.NotificationRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Notification) object, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            io.realm.BillRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Bill) object, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            io.realm.StudentRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Student) object, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            io.realm.BookRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Book) object, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            io.realm.GradeRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Grade) object, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            io.realm.CourseRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Course) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
                io.realm.NotificationRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Notification) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
                io.realm.BillRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Bill) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
                io.realm.StudentRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Student) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
                io.realm.BookRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Book) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
                io.realm.GradeRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Grade) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
                io.realm.CourseRealmProxy.insert(realm, (com.fitzafful.gliveportal.db.Course) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
                    io.realm.NotificationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
                    io.realm.BillRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
                    io.realm.StudentRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
                    io.realm.BookRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
                    io.realm.GradeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
                    io.realm.CourseRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            io.realm.NotificationRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Notification) obj, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            io.realm.BillRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Bill) obj, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            io.realm.StudentRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Student) obj, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            io.realm.BookRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Book) obj, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            io.realm.GradeRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Grade) obj, cache);
        } else if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            io.realm.CourseRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Course) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
                io.realm.NotificationRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Notification) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
                io.realm.BillRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Bill) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
                io.realm.StudentRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Student) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
                io.realm.BookRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Book) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
                io.realm.GradeRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Grade) object, cache);
            } else if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
                io.realm.CourseRealmProxy.insertOrUpdate(realm, (com.fitzafful.gliveportal.db.Course) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
                    io.realm.NotificationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
                    io.realm.BillRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
                    io.realm.StudentRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
                    io.realm.BookRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
                    io.realm.GradeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
                    io.realm.CourseRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            return clazz.cast(io.realm.BillRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            return clazz.cast(io.realm.StudentRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            return clazz.cast(io.realm.BookRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            return clazz.cast(io.realm.GradeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            return clazz.cast(io.realm.CourseRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            return clazz.cast(io.realm.BillRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            return clazz.cast(io.realm.StudentRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            return clazz.cast(io.realm.BookRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            return clazz.cast(io.realm.GradeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            return clazz.cast(io.realm.CourseRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.fitzafful.gliveportal.db.Notification.class)) {
            return clazz.cast(io.realm.NotificationRealmProxy.createDetachedCopy((com.fitzafful.gliveportal.db.Notification) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Bill.class)) {
            return clazz.cast(io.realm.BillRealmProxy.createDetachedCopy((com.fitzafful.gliveportal.db.Bill) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Student.class)) {
            return clazz.cast(io.realm.StudentRealmProxy.createDetachedCopy((com.fitzafful.gliveportal.db.Student) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Book.class)) {
            return clazz.cast(io.realm.BookRealmProxy.createDetachedCopy((com.fitzafful.gliveportal.db.Book) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Grade.class)) {
            return clazz.cast(io.realm.GradeRealmProxy.createDetachedCopy((com.fitzafful.gliveportal.db.Grade) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.fitzafful.gliveportal.db.Course.class)) {
            return clazz.cast(io.realm.CourseRealmProxy.createDetachedCopy((com.fitzafful.gliveportal.db.Course) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
