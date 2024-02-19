package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class NotificationRealmProxy extends com.fitzafful.gliveportal.db.Notification
    implements RealmObjectProxy, NotificationRealmProxyInterface {

    static final class NotificationColumnInfo extends ColumnInfo {
        long idIndex;
        long noticetypeIndex;
        long descriptionIndex;
        long venueIndex;
        long createdDateIndex;
        long readIndex;

        NotificationColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Notification");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.noticetypeIndex = addColumnDetails("noticetype", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", objectSchemaInfo);
            this.venueIndex = addColumnDetails("venue", objectSchemaInfo);
            this.createdDateIndex = addColumnDetails("createdDate", objectSchemaInfo);
            this.readIndex = addColumnDetails("read", objectSchemaInfo);
        }

        NotificationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new NotificationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final NotificationColumnInfo src = (NotificationColumnInfo) rawSrc;
            final NotificationColumnInfo dst = (NotificationColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.noticetypeIndex = src.noticetypeIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.venueIndex = src.venueIndex;
            dst.createdDateIndex = src.createdDateIndex;
            dst.readIndex = src.readIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("id");
        fieldNames.add("noticetype");
        fieldNames.add("description");
        fieldNames.add("venue");
        fieldNames.add("createdDate");
        fieldNames.add("read");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private NotificationColumnInfo columnInfo;
    private ProxyState<com.fitzafful.gliveportal.db.Notification> proxyState;

    NotificationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (NotificationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.fitzafful.gliveportal.db.Notification>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$noticetype() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.noticetypeIndex);
    }

    @Override
    public void realmSet$noticetype(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.noticetypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.noticetypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.noticetypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.noticetypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$venue() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.venueIndex);
    }

    @Override
    public void realmSet$venue(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.venueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.venueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.venueIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.venueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdDateIndex);
    }

    @Override
    public void realmSet$createdDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$read() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.readIndex);
    }

    @Override
    public void realmSet$read(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.readIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.readIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Notification", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("noticetype", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("venue", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("createdDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("read", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NotificationColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new NotificationColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Notification";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.fitzafful.gliveportal.db.Notification createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.fitzafful.gliveportal.db.Notification obj = null;
        if (update) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Notification.class);
            NotificationColumnInfo columnInfo = (NotificationColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class), false, Collections.<String> emptyList());
                    obj = new io.realm.NotificationRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.NotificationRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Notification.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.NotificationRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Notification.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final NotificationRealmProxyInterface objProxy = (NotificationRealmProxyInterface) obj;
        if (json.has("noticetype")) {
            if (json.isNull("noticetype")) {
                objProxy.realmSet$noticetype(null);
            } else {
                objProxy.realmSet$noticetype((String) json.getString("noticetype"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("venue")) {
            if (json.isNull("venue")) {
                objProxy.realmSet$venue(null);
            } else {
                objProxy.realmSet$venue((String) json.getString("venue"));
            }
        }
        if (json.has("createdDate")) {
            if (json.isNull("createdDate")) {
                objProxy.realmSet$createdDate(null);
            } else {
                objProxy.realmSet$createdDate((String) json.getString("createdDate"));
            }
        }
        if (json.has("read")) {
            if (json.isNull("read")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'read' to null.");
            } else {
                objProxy.realmSet$read((boolean) json.getBoolean("read"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.fitzafful.gliveportal.db.Notification createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.fitzafful.gliveportal.db.Notification obj = new com.fitzafful.gliveportal.db.Notification();
        final NotificationRealmProxyInterface objProxy = (NotificationRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("noticetype")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$noticetype((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$noticetype(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("venue")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$venue((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$venue(null);
                }
            } else if (name.equals("createdDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$createdDate(null);
                }
            } else if (name.equals("read")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$read((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'read' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.fitzafful.gliveportal.db.Notification copyOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Notification object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Notification) cachedRealmObject;
        }

        com.fitzafful.gliveportal.db.Notification realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Notification.class);
            NotificationColumnInfo columnInfo = (NotificationColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class);
            long pkColumnIndex = columnInfo.idIndex;
            Number value = ((NotificationRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.NotificationRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.fitzafful.gliveportal.db.Notification copy(Realm realm, com.fitzafful.gliveportal.db.Notification newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Notification) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.fitzafful.gliveportal.db.Notification realmObject = realm.createObjectInternal(com.fitzafful.gliveportal.db.Notification.class, ((NotificationRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        NotificationRealmProxyInterface realmObjectSource = (NotificationRealmProxyInterface) newObject;
        NotificationRealmProxyInterface realmObjectCopy = (NotificationRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$noticetype(realmObjectSource.realmGet$noticetype());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$venue(realmObjectSource.realmGet$venue());
        realmObjectCopy.realmSet$createdDate(realmObjectSource.realmGet$createdDate());
        realmObjectCopy.realmSet$read(realmObjectSource.realmGet$read());
        return realmObject;
    }

    public static long insert(Realm realm, com.fitzafful.gliveportal.db.Notification object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Notification.class);
        long tableNativePtr = table.getNativePtr();
        NotificationColumnInfo columnInfo = (NotificationColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class);
        long pkColumnIndex = columnInfo.idIndex;
        Object primaryKeyValue = ((NotificationRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$noticetype = ((NotificationRealmProxyInterface) object).realmGet$noticetype();
        if (realmGet$noticetype != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noticetypeIndex, rowIndex, realmGet$noticetype, false);
        }
        String realmGet$description = ((NotificationRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$venue = ((NotificationRealmProxyInterface) object).realmGet$venue();
        if (realmGet$venue != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.venueIndex, rowIndex, realmGet$venue, false);
        }
        String realmGet$createdDate = ((NotificationRealmProxyInterface) object).realmGet$createdDate();
        if (realmGet$createdDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((NotificationRealmProxyInterface) object).realmGet$read(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Notification.class);
        long tableNativePtr = table.getNativePtr();
        NotificationColumnInfo columnInfo = (NotificationColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Notification object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Notification) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            Object primaryKeyValue = ((NotificationRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$noticetype = ((NotificationRealmProxyInterface) object).realmGet$noticetype();
            if (realmGet$noticetype != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.noticetypeIndex, rowIndex, realmGet$noticetype, false);
            }
            String realmGet$description = ((NotificationRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$venue = ((NotificationRealmProxyInterface) object).realmGet$venue();
            if (realmGet$venue != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.venueIndex, rowIndex, realmGet$venue, false);
            }
            String realmGet$createdDate = ((NotificationRealmProxyInterface) object).realmGet$createdDate();
            if (realmGet$createdDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((NotificationRealmProxyInterface) object).realmGet$read(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Notification object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Notification.class);
        long tableNativePtr = table.getNativePtr();
        NotificationColumnInfo columnInfo = (NotificationColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class);
        long pkColumnIndex = columnInfo.idIndex;
        Object primaryKeyValue = ((NotificationRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$noticetype = ((NotificationRealmProxyInterface) object).realmGet$noticetype();
        if (realmGet$noticetype != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noticetypeIndex, rowIndex, realmGet$noticetype, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.noticetypeIndex, rowIndex, false);
        }
        String realmGet$description = ((NotificationRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$venue = ((NotificationRealmProxyInterface) object).realmGet$venue();
        if (realmGet$venue != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.venueIndex, rowIndex, realmGet$venue, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.venueIndex, rowIndex, false);
        }
        String realmGet$createdDate = ((NotificationRealmProxyInterface) object).realmGet$createdDate();
        if (realmGet$createdDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdDateIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((NotificationRealmProxyInterface) object).realmGet$read(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Notification.class);
        long tableNativePtr = table.getNativePtr();
        NotificationColumnInfo columnInfo = (NotificationColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Notification.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Notification object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Notification) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            Object primaryKeyValue = ((NotificationRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((NotificationRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$noticetype = ((NotificationRealmProxyInterface) object).realmGet$noticetype();
            if (realmGet$noticetype != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.noticetypeIndex, rowIndex, realmGet$noticetype, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.noticetypeIndex, rowIndex, false);
            }
            String realmGet$description = ((NotificationRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$venue = ((NotificationRealmProxyInterface) object).realmGet$venue();
            if (realmGet$venue != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.venueIndex, rowIndex, realmGet$venue, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.venueIndex, rowIndex, false);
            }
            String realmGet$createdDate = ((NotificationRealmProxyInterface) object).realmGet$createdDate();
            if (realmGet$createdDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdDateIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((NotificationRealmProxyInterface) object).realmGet$read(), false);
        }
    }

    public static com.fitzafful.gliveportal.db.Notification createDetachedCopy(com.fitzafful.gliveportal.db.Notification realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.fitzafful.gliveportal.db.Notification unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.fitzafful.gliveportal.db.Notification();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.fitzafful.gliveportal.db.Notification) cachedObject.object;
            }
            unmanagedObject = (com.fitzafful.gliveportal.db.Notification) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        NotificationRealmProxyInterface unmanagedCopy = (NotificationRealmProxyInterface) unmanagedObject;
        NotificationRealmProxyInterface realmSource = (NotificationRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$noticetype(realmSource.realmGet$noticetype());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$venue(realmSource.realmGet$venue());
        unmanagedCopy.realmSet$createdDate(realmSource.realmGet$createdDate());
        unmanagedCopy.realmSet$read(realmSource.realmGet$read());

        return unmanagedObject;
    }

    static com.fitzafful.gliveportal.db.Notification update(Realm realm, com.fitzafful.gliveportal.db.Notification realmObject, com.fitzafful.gliveportal.db.Notification newObject, Map<RealmModel, RealmObjectProxy> cache) {
        NotificationRealmProxyInterface realmObjectTarget = (NotificationRealmProxyInterface) realmObject;
        NotificationRealmProxyInterface realmObjectSource = (NotificationRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$noticetype(realmObjectSource.realmGet$noticetype());
        realmObjectTarget.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectTarget.realmSet$venue(realmObjectSource.realmGet$venue());
        realmObjectTarget.realmSet$createdDate(realmObjectSource.realmGet$createdDate());
        realmObjectTarget.realmSet$read(realmObjectSource.realmGet$read());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Notification = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{noticetype:");
        stringBuilder.append(realmGet$noticetype() != null ? realmGet$noticetype() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{venue:");
        stringBuilder.append(realmGet$venue() != null ? realmGet$venue() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdDate:");
        stringBuilder.append(realmGet$createdDate() != null ? realmGet$createdDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{read:");
        stringBuilder.append(realmGet$read());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationRealmProxy aNotification = (NotificationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aNotification.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNotification.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aNotification.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
