package com.slayer.service.persistence;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.slayer.model.LMSBook;
import com.slayer.model.impl.LMSBookImpl;

import java.util.List;

public class LMSBookFinderImpl extends BasePersistenceImpl<LMSBook> implements LMSBookFinder{
	static String FIND_BOOKS =
			
			LMSBookFinderImpl.class.getName() + ".findBooks";
			@SuppressWarnings("unchecked")
			public List<LMSBook> findBooks(String bookTitle)
			throws SystemException {
			// 1. Open an ORM session
			Session session = openSession();
			// 2. Get SQL statement from XML file with its name
			String sql = CustomSQLUtil.get(FIND_BOOKS);
			
			System.out.println("SQL >> " + sql);
			// 3. Transform the normal query to HQL query
			SQLQuery query = session.createSQLQuery(sql);
			// 4. Add the actual entity to be searched
			query.addEntity("LMSBook", LMSBookImpl.class);
			// 5. Replace positional parameters in the query
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(bookTitle);
			// 6. Execute query and return results.
			return (List<LMSBook>) query.list();
			}
}
